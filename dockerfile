# First stage: bundle the app (Transforme the Angular app into a static website)
FROM node:16 AS bundler 

WORKDIR /tmp

COPY . .

RUN yarn install && yarn build

# Second stage: serve the app with nginx
FROM nginx:latest

COPY ./nginx.conf /etc/nginx/conf.d/default.conf

COPY --from=bundler /tmp/dist/coiffex /usr/share/html

RUN chmod 755 /usr/share/html
# Give the proper rights to the folder to be able to read the files inside

EXPOSE 80
