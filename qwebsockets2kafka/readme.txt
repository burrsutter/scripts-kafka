Setup your phone for debugging from MacOS.  You need a phone to grab accelerometer data

MacOS Safari to iOS Safari
https://medium.com/@mattcroak718/debugging-your-iphone-mobile-web-app-using-safari-development-tools-71240657c487

Note: phone normally needs to be physically plugged in via USB to the MacBook.

Terminal 1:
cd kafka-docker
docker-compose up

Terminal 2:
cd ..
cd qkafkaconsumer
note: application.properties points to shaketopic
mvn compile quarkus:dev

Terminal 3:
cd  qwebsockets2kafka

mvn compile quarkus:dev

Open the mobile browser on the ip address for your desktop/laptop computer, they need to be on the same network

Shake the phone


