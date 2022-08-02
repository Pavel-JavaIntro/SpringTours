# SpringTours

Java course project

Идея приложения состоит в следующем:
Менеджер турфирмы наполняет сайт предложениями различных экскурсионных туров (впоследствии, если времени хватит, через какое-нибудь REST API), 
Tурист выбирает и регистрируется на выбранный тур.
К приложению поддерживается доступ как через REST API, так и через браузер с представлением в JSP.
Имеются следующие роли (каждая последующая расширяет функционал предыдущей):
- TOURIST: может просматривать имеющиеся туры, регистрироваться на них и отменять регистрацию
- MANAGER: может просматривать список туристов, блокировать и разблокировать их доступ, добавлять и удалять туры и их типы, 
менять статус платежа
- ADMIN: может давать права MANAGER'а работникам турфирмы
Само приложение отслеживает количество заявок на каждый тур, закрывает доступ к регистрации на тур при достижении предельного 
количества заявок или наступления даты тура, сохраняет записи о турах и бронированиях в базе данных.
- 
План действий:
- Закончить браузерный интерфейс с ролями,
- Подготовить загрузочный скрипт
- Добавить тесты,
- Перехватить исключения,
- Проработать Swagger,
- Позаботиться о Security в REST API,
- Задуматься о многопоточности