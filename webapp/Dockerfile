# Fetching the latest node image on apline linux
FROM node:alpine AS development

# Setting up the work directory
WORKDIR /react-app

# Installing dependencies
COPY ./package.json /react-app
RUN yarn add

# Copying all the files in our project
COPY . .

# Starting our application
EXPOSE 3000
CMD yarn start