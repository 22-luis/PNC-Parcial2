# PNC-Parcial2

### Luis Molina - 00016720
### Carlos Rodriguez - 00402720

# docker-compose
services:
  postgres:
    image: postgres:15
    container_name: my_postgres
    restart: unless-stopped
    environment:
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: mysecretpassword
      POSTGRES_DB: mydatabase
    ports:
      - "5432:5432"
    volumes:
      - postgres_data:/var/lib/postgresql/data

volumes:
  postgres_data:
