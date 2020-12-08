Simple microservice with docker

mkdir build/dependency
cd build/dependency 
jar -xf ../libs/*.jar
docker build -t vsanyc/simple-microservice .