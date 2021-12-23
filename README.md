## REST_Calculator адаптер к SOAP - сервису dneonline.com/calculator

### Описание
Проект REST-сервиса-адаптера к SOAP веб-сервису http://www.dneonline.com/calculator.asmx
Предусмотрена валидация запросов к REST-сервису на предмет наличия необходимых полей, корректности формата и наличия значения
Сервис обладает спецификацией в формате OpenAPI (SWAGGER)
/swagger-ui.html
http://localhost:8087/swagger-ui.html

### Запуск приложения 
** Должен быть установлен Docker

1.  docker build -t rest_calculator:1.0 .
2.  docker run -d -p 8087:8087 rest_calculator:1.0
3.  вводим команду **docker ps** чтобы увидеть запущенный контейнер