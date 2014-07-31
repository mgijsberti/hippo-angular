#!/bin/bash
# Script deploy app into Apache
set -x
USER=$1
VERSION=$2
ROOT=''

if [ ${USER} = 'maven' ]
then
    ROOT='src/'
fi

echo "version: ${VERSION}"

DOCUMENT_ROOT='/Library/WebServer/Documents'
APACHE_LOG='/private/var/log/apache2'
ROOTAPP='app'
HIPPO='hippo'
APP='greeting'
sudo apachectl stop
sudo mkdir -p ${DOCUMENT_ROOT}/${ROOTAPP}/${HIPPO}
sudo mkdir -p ${DOCUMENT_ROOT}/${ROOTAPP}/${APP}
sudo apachectl start
sudo tail -f ${APACHE_LOG}/*