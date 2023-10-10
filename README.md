Database test

docker run --rm --name account_db -e POSTGRES_USER=account_db -e POSTGRES_PASSWORD=mysecretpassword -p 5432:5432 postgres