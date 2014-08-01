Instructions for setting up the Hippo Angular client project.
=============================================================

1) Clone the https://github.com/mgijsberti/gs-rest-service.git into a local project, and start up the greeting service.

2) Install Apache Httpd Webserver (https://httpd.apache.org/) on your local machine, and start it up under localhost. Make sure that mod_proxy module  (http://httpd.apache.org/docs/2.2/mod/mod_proxy.html) for Forward and Reverse proxies is installed

3) Virtualhost configuration in apache.

<VirtualHost *:80>
      ServerName cms.example.com

      ProxyPreserveHost Off

      ProxyPass          /app                 !
      ProxyPass /site/ http://127.0.0.1:8080/site/
      ProxyPass / http://127.0.0.1:8080/cms/
      ProxyPassReverse / http://127.0.0.1:8080/cms/
      ProxyPassReverseCookiePath /cms /
</VirtualHost>


<VirtualHost *:80>
      ServerName www.example.com
      ServerAlias *.example.com

      ProxyPreserveHost  On

      ProxyPass          /app                 !
      ProxyPass  / http://127.0.0.1:8080/site/
      ProxyPassReverse  / http://127.0.0.1:8080/site/
      ProxyPassReverseCookiePath  /site /

</VirtualHost>

4) Add to your /etc/hosts to following line
127.0.0.1	localhost  www.example.com cms.example.com

See http://www.onehippo.org/library/deployment/configuring/configure-apache-httpd-web-server-for-cms-and-sites.html for details about this setup.


4) In the project
mvn clean install
mvn -Pcargo.run -Drepo.path=storage

5) Browse to www.example.com in your browser

6) Browser to http://www.example.com/greeting and test the greeting application. It should give back the name you enter in the input field.

7) Login into the cms (http://http://cms.example.com) and go to the channel manager. Check if you can remove and add the greeting component in the channel manager. What happens if you configure the component with the wrong url ?
   
   
