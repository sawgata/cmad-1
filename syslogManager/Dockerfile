FROM node:8.9.0

RUN mkdir -p /app
WORKDIR /app

RUN npm install -g nodemon
RUN npm config set registry https://registry.npmjs.org
COPY package.json /app/package.json
RUN npm install \
 && npm ls \
 && npm cache clean --force \
 && mv /app/node_modules /node_modules
COPY . /app

EXPOSE 8081

#CMD ["npm", "start"]
ENTRYPOINT ["npm", "start", "-H", "0.0.0.0"]
