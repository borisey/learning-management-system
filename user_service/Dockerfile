# PHP образ
FROM php:8.2-fpm

# Указываю рабочую директорию
WORKDIR /var/www/html

# Устанавливаю зависимости
RUN apt-get update && apt-get install -y \
    git \
    unzip \
    libpng-dev \
    libjpeg-dev \
    libfreetype6-dev \
    libzip-dev \
    zip \
    postgresql \
    libpq-dev \
    libpq5 \
    && docker-php-ext-configure gd --with-freetype --with-jpeg \
    && docker-php-ext-install gd pdo pdo_mysql pdo_pgsql zip

COPY --from=composer:latest /usr/bin/composer /usr/bin/composer

COPY . /var/www/html

RUN composer install

COPY --chown=www-data:www-data . /var/www/html

USER www-data

EXPOSE 81

CMD ["/var/www/html/yii", "serve", "0.0.0.0:81"]
CMD ["/var/www/html/yii", "migrate"]
