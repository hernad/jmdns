

    mvn package



    javac -cp ./jmdns-3.5.2-SNAPSHOT.jar:. HelloService.java
    javac -cp ./jmdns-3.5.2-SNAPSHOT.jar:. HelloListenService.java

    java -cp ./jmdns-3.5.2-SNAPSHOT.jar:. HelloService
    java -cp ./jmdns-3.5.2-SNAPSHOT.jar:. HelloListenService





hernads-MacBook-Air:example hernad$ dig -x 192.168.169.194 @224.0.0.251 -p 5353

<pre>
; <<>> DiG 9.8.3-P1 <<>> -x 192.168.169.194 @224.0.0.251 -p 5353
;; global options: +cmd
;; Got answer:
;; ->>HEADER<<- opcode: QUERY, status: NOERROR, id: 4865
;; flags: qr aa; QUERY: 1, ANSWER: 1, AUTHORITY: 0, ADDITIONAL: 0

;; QUESTION SECTION:
;194.169.168.192.in-addr.arpa.	IN	PTR

;; ANSWER SECTION:
194.169.168.192.in-addr.arpa. 10 IN	PTR	SEC001599E98974.local.

;; Query time: 1582 msec
;; SERVER: 192.168.169.194#5353(224.0.0.251)
;; WHEN: Wed Jul  5 20:25:44 2017
;; MSG SIZE  rcvd: 81
</pre>


hernads-MacBook-Air:example hernad$ ping SEC001599E98974.local.

<pre>
PING sec001599e98974.local (192.168.169.194): 56 data bytes
64 bytes from 192.168.169.194: icmp_seq=0 ttl=64 time=4.100 ms
</pre>



hernads-MacBook-Air:example hernad$ java -cp ./jmdns-3.5.2-SNAPSHOT.jar:. HelloListenService

<pre>
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Service added: [ServiceInfoImpl@361240938 name: 'service1._http._tcp.local.' address: '(null):0' status: 'DNS: hernads-MacBook-Air.local. [hernads-MacBook-Air.local/192.168.169.188] state: probing 1 task: null', has NO data empty]
Service resolved: [ServiceInfoImpl@527462938 name: 'service1._http._tcp.local.' address: '/192.168.169.188:999 ' status: 'DNS: hernads-MacBook-Air.local. [hernads-MacBook-Air.local/192.168.169.188] state: probing 1 task: null' is persistent, has data
	path: index.html;test=004303404034030430
]
Service added: [ServiceInfoImpl@258277117 name: 'Samsung ML-2160 Series (SEC001599E98974)._http._tcp.local.' address: '(null):0' status: 'DNS: hernads-MacBook-Air.local. [hernads-MacBook-Air.local/192.168.169.188] state: probing 1 task: null', has NO data empty]
Service resolved: [ServiceInfoImpl@1809985543 name: 'Samsung ML-2160 Series (SEC001599E98974)._http._tcp.local.' address: '/192.168.169.194:80 ' status: 'DNS: hernads-MacBook-Air.local. [hernads-MacBook-Air.local/192.168.169.188] state: probing 1 task: null' is persistent, has data empty]
</pre>




hernads-MacBook-Air:example hernad$ dig @224.0.0.251 -p 5353  service1._http._tcp.local

<pre>
; <<>> DiG 9.8.3-P1 <<>> @224.0.0.251 -p 5353 service1._http._tcp.local
; (1 server found)
;; global options: +cmd
;; Got answer:
;; ->>HEADER<<- opcode: QUERY, status: NOERROR, id: 36630
;; flags: qr aa; QUERY: 1, ANSWER: 1, AUTHORITY: 0, ADDITIONAL: 0

;; QUESTION SECTION:
;service1._http._tcp.local.	IN	A

;; ANSWER SECTION:
hAir.local.		3599	IN	A	192.168.169.188 <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

;; Query time: 1 msec
;; SERVER: 192.168.169.188#5353(224.0.0.251)
;; WHEN: Wed Jul  5 20:48:32 2017
;; MSG SIZE  rcvd: 64
</pre>

hernads-MacBook-Air:example hernad$ ping -c1 hAir.local
<pre>
PING hair.local (192.168.169.188): 56 data bytes
64 bytes from 192.168.169.188: icmp_seq=0 ttl=64 time=0.131 ms
</pre>

