#ubuntu 16.04
#sudo apt-get update && apt-get install -y apt-transport-https
#sudo apt install docker.io
#sudo systemctl start docker
#sudo systemctl enable docker
#sudo curl -L https://github.com/docker/compose/releases/download/1.22.0/docker-compose-$(uname -s)-$(uname -m) -o /usr/local/bin/docker-compose
#sudo chmod +x /usr/local/bin/docker-compose
#apt-get -y install maven
#export JAVAHOME=
cd "$(dirname "$0")"
#build
#  mvn package

#start 
   docker-compose -f docker-compose.yml up -d

#restart 
#  docker-compose -f docker-compose.yml restart web

#check status 
#  docker exec -ti web bash -c "service app_service status"

#stop service 
#  docker exec -ti web bash -c "service app_service stop"

#check logs
#   docker exec -ti web bash -c "tail -100f /opt/app/insurance-assignment.log"
