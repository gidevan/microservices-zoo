Simple microservice with reactor framework.

mkdir build/dependency
cd build/dependency 
jar -xf ../libs/*.jar
docker build -t vsanyc/simple-reactor-microservice .