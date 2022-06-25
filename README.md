# Project Title - restful-brooker
Web testing

## Getting Started
git clone https://github.com/OlufemiAdeOlusile/restful-brooker.git

### Prerequisites
Docker and GIT

### Installing
* Clone the repo
* Navigate to the project directory for the cloned repo (e.g, /download/restful-brooker).
* Edit configuration in docker-compose.yml
    > * Default port for chrome in compose is **4444:4444**, you can change if port is 
    already in use (e.g `<port4Chrome>`:4444)
    > * Default port for vnc viewer in compose is **5900:5900**, you can change if port is 
    already in use (e.g `<port4VNC>`:5900)
    > * Include remote uri in *-Dbrowser.remote_uri*. Get host machine IP address. For example using 
    *ifconfig* on your terminal and search for IPv4 address or inet addr. 
   **http://`<HostIPADD>`:`<port4firefox>`/wd/hub** (e.g, **'http://194.133.4.53:4444/wd/hub'**)
 
    
````yaml
version: "3"
services:
  firefox:
    image: seleniarm/standalone-firefox
    ports:
      - "5900:5900"
      - "4444:4444"

  maven:
    image: maven
    stop_signal: SIGKILL
    stdin_open: true
    tty: true
    working_dir: $PWD
    volumes:
      - $PWD:$PWD
      - /var/run/docker.sock:/var/run/docker.sock
      - ~/.m2:/root/.m2
    command: bash -c "mvn clean install &&
      mvn verify -pl functionaltest
      -Dbrowser.remote_uri='http://127.0.0.1:4444/wd/hub'
      -Dtest.url='https://www.mailtravel.co.uk/'
      -Dskip.tests='false'
      -Dbrowser.type='firefox'" 
````

### Running the tests
* To run in foreground,  
> ***$ docker-compose up*** 
> Please note that images can change due to different Macs (M1 or Intel)
> If you are using the M1 please run docker compose to build spin up selenium and run the tests via the testng default-suite.xml(functionaltest/src/test/resources/default-suite.xml). **Maven image does not support M1s yet**
> If you are running on an intel Mac, please change the image in the docker compose file to selenium/standalone-firefox
> You can run multi browser for firefox or chrome as long as you change the **Dbrowser.type** to either **(chrome|firefox)**
> Regular test results can be found in the target folder


* View test run by using the VNC server. In your browser type in vnc://localhost:5900 or vnc://`<HostIPADD>`:`<port4VNC>`
When you are prompted for the password it is **secret**



### Authors
Olufemi Ade-Olusile


