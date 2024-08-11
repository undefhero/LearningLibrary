FROM node:20-alpine AS base

RUN apk add --no-cache libc6-compat
WORKDIR /app

COPY . .

EXPOSE 3000

CMD ["npm", "start"]