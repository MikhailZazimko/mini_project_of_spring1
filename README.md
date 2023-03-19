Проект по теме: Spring (1)
Тема: CRUD на Spring MVC
Нужно сделать список задач (todo-list) с возможностью просматривать список задач, добавлять новые задачи, редактировать и удалять существующие задачи.
Желательно, не использовать Spring Boot, а самому разобраться как все сконфигурировать.

Что нужно сделать:
Развернуть sql скрипт
CREATE DATABASE  IF NOT EXISTS `todo` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `todo`;
DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(100) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT  IGNORE INTO `task` VALUES (1,'aaa',1),(2,'bbb',2),(3,'ccc',0),(4,'ddd',1),(5,'eee',2),(6,'fff',0),(7,'ggg',1),(8,'hhh',2),(9,'jjj',0),(10,'kkk',1),(11,'lll',2),(12,'mmm',0),(13,'nnn',1),(14,'ooo',2),(15,'ppp',0);
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;
Создать новый Maven проект.
Добавить зависимости, которые нужны для работы с MySQL, Hibernate, Spring, Spring MVC, Thymeleaf.
Добавить в проект ентити слой (пакет domain). Добавить класс Task – он будет отвечать за задачу в списке дел. Необходимые поля: description – описание задачи, status – статус выполнения задачи. В качестве статуса используй энам:
public enum Status {
    IN_PROGRESS,
    DONE,
    PAUSED
}

Добавь пакет config. В нем размести необходимые классы настройки Spring MVC приложения, работы с БД (через Hibernate) и все прочие настройки.

Добавь dao слой, в котором должен быть класс TaskDAO, который будет отвечать за работу с БД. Методы, которые должны быть – CRUD и поддержка пейджинга.

Добавь сервисный слой, в котором размести логику по созданию и редактированию задач.

Теперь слой контроллера: в нем должны быть методы:
получить список задач (с учетом пейджинга)
добавить новую задачу
отредактировать существующую задачу
удалить задачу

Какими должны быть методы и их маппинги продумай сам.

Последний шаг – шаблон (html или js файл). Опционально, можно вынести стили и скрипты в разные файлы по типам. Как обычно, для бекэнд разработчика важен функционал, а не внешний вид, поэтому каким будет визуал приложенния – на твое усмотрение.
