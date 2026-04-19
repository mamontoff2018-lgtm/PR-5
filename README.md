<div align="center">

# Отчет

</div>

<div align="center">

## Практическая работа №5

</div>

<div align="center">

## Работа с несколькими окнами (Activity)

</div>

**Выполнил:**  
Покидов Матвей Юрьевич

**Курс:** 2

**Группа:** ИНС-б-о-24-1

**Направление:** 09.03.02

**Профиль:** Информационные системы и технологии

---

### Цель работы
Научиться создавать многоэкранные приложения, осуществлять навигацию между активностями (Activity) и передавать данные между ними с использованием объектов Intent и механизма startActivityForResult / onActivityResult.

### Ход работы

В результате выполнения основного задания получилось сделать следующее оформление главного экрана:

</div>

<div align="center">
   
![Главный экран](https://github.com/mamontoff2018-lgtm/PR-5/blob/master/Рисунок1.png)

**Рисунок 1** — Главный экран приложения (MainActivity)

</div>

### Задания для самостоятельного выполнения

**Вариант 5:** Изменение количества отображаемых прямоугольников на главной странице (динамическое добавление View).

#### Создание проекта и настройка главного экрана

Создаем новый проект с шаблоном Empty Views Activity. Название проекта: `MultiWindowLab`.

В файле `activity_main.xml` создаем интерфейс с кнопками "Настройки", "Об авторе" и контейнером для динамического отображения прямоугольников.

</div>

<div align="center">
   
![Разметка главного экрана](https://github.com/mamontoff2018-lgtm/PR-5/blob/master/Рисунок2.png)

**Рисунок 2** — Разметка `activity_main.xml` с LinearLayout для прямоугольников

</div>

#### Создание Activity "Настройки" (SettingsActivity)

Разрабатываем интерфейс для выбора количества прямоугольников. Используем SeekBar для выбора числа.

</div>

<div align="center">
   
![Разметка настроек](https://github.com/mamontoff2018-lgtm/PR-5/blob/master/Рисунок3.png)

**Рисунок 3** — Разметка `activity_settings.xml`

</div>

Логика SettingsActivity: получаем выбранное значение и возвращаем его в MainActivity.

#### Создание Activity "Об авторе" (AboutActivity)

Создаем AboutActivity с информацией об авторе. Используем обычный startActivity() без возврата результата.

</div>

<div align="center">
   
![Разметка AboutActivity](https://github.com/mamontoff2018-lgtm/PR-5/blob/master/Рисунок4.png)

**Рисунок 4** — Разметка `activity_about.xml`

</div>

Теперь создаем Activity "Настройки" (SettingsActivity)

</div>

<div align="center">
   
![Разметка](https://github.com/mamontoff2018-lgtm/PR-5/blob/master/Рисунок5.png)

**Рисунок 5** — Разметка `SettingsActivity.kt`

</div>

Далее такое же создаем для Activity "Об авторе" (AboutActivity)

</div>

<div align="center">
   
![Код AboutActivity](https://github.com/mamontoff2018-lgtm/PR-5/blob/master/Рисунок6.png)

**Рисунок 6** — Логика `AboutActivity.kt`

</div>

Реализуем получение результатов из AboutActivity и SettingsActivity в MainActivity

</div>

<div align="center">
   
![Код MainActivity часть 1](https://github.com/mamontoff2018-lgtm/PR-5/blob/master/Рисунок7.png)

**Рисунок 7** — Логика `MainActivity.kt` (onCreate и обработчики кнопок)

</div>

#### Демонстрация приложения:

</div>

<div align="center">
   
![Результат](https://github.com/mamontoff2018-lgtm/PR-5/blob/master/Рисунок8.png)

**Рисунок 8** — Начальный экран

</div>

</div>

<div align="center">
   
![Результат](https://github.com/mamontoff2018-lgtm/PR-5/blob/master/Рисунок9.png)

**Рисунок 9** — вкладка об авторе

</div>

</div>

<div align="center">
   
![Результат](https://github.com/mamontoff2018-lgtm/PR-5/blob/master/Рисунок10.png)

**Рисунок 10** — вкладка настройки и выбора кол-ва кругов

</div>

</div>

<div align="center">
   
![Результат](https://github.com/mamontoff2018-lgtm/PR-5/blob/master/Рисунок11.png)

**Рисунок 11** — возврат в главное меню с выбранным количеством кругов в меню

</div>


### Вывод
В ходе выполнения практической работы №5:
- Изучены принципы создания многоэкранных приложений на платформе Android.
- Реализована навигация между тремя Activity с использованием явных Intent.
- Освоена передача данных между Activity через Intent и механизм startActivityForResult / onActivityResult.
- Выполнено самостоятельное задание (вариант 5 — изменение количества отображаемых прямоугольников).
- Реализовано динамическое добавление View в контейнер LinearLayout.
- Приложение стабильно работает на эмуляторе и реальном устройстве.

---
### Ответы на контрольные вопросы

1. **Что такое Intent? Какие существуют типы Intent (явные и неявные)? Приведите примеры использования каждого типа.**

   **Intent** — это абстрактное описание операции, которое используется для запуска Activity, сервисов или доставки широковещательных сообщений.

   - **Явный Intent (Explicit Intent)** — точно указывает, какой компонент (класс) следует запустить. Используется для навигации внутри собственного приложения.
     ```java
     Intent intent = new Intent(MainActivity.this, SecondActivity.class);
     startActivity(intent);
     ```

   - **Неявный Intent (Implicit Intent)** — описывает действие, которое нужно выполнить (например, открыть веб-страницу, позвонить). Система сама находит подходящее приложение для его выполнения.
     ```java
     Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com"));
     startActivity(intent);
     ```

2. **Как передать данные из одной Activity в другую с помощью Intent? Какие ограничения на типы передаваемых данных существуют?**

   Для передачи данных используется метод `putExtra()` объекта Intent. Данные хранятся в виде пар "ключ-значение".

   ```java
   // Передача
   Intent intent = new Intent(MainActivity.this, SecondActivity.class);
   intent.putExtra("USER_NAME", "Иванов Иван");
   intent.putExtra("USER_AGE", 20);
   startActivity(intent);

   // Получение
   Intent intent = getIntent();
   String name = intent.getStringExtra("USER_NAME");
   int age = intent.getIntExtra("USER_AGE", 0);
   ```

   **Ограничения:** можно передавать примитивные типы, строки, массивы, ArrayList, Bundle, Parcelable и Serializable объекты. Нельзя передавать большие объёмы данных (более ~1 Мб) и объекты, не реализующие Parcelable/Serializable.

3. **В чем разница между методами startActivity() и startActivityForResult()? В каких случаях используется каждый из них?**

   - `startActivity()` — запускает новую Activity и не ожидает от неё возврата результата. Используется, когда результат не нужен (например, переход на экран "Об авторе").

   - `startActivityForResult()` — запускает Activity и ожидает от неё результат. Используется, когда нужно получить данные обратно (например, выбор настроек, выбор контакта, фото с камеры).

4. **Опишите назначение методов setResult() и finish() в контексте возврата данных из дочерней Activity.**

   - `setResult(int resultCode, Intent data)` — устанавливает результат, который будет возвращен родительской Activity. Принимает код результата (RESULT_OK или RESULT_CANCELED) и Intent с данными.

   - `finish()` — закрывает текущую Activity и возвращает управление родительской Activity. После вызова finish() система вызывает onActivityResult() в родительской Activity.

5. **Что произойдёт, если не зарегистрировать Activity в файле AndroidManifest.xml?**

   Приложение вылетит с ошибкой `ActivityNotFoundException`. Система не сможет найти и запустить Activity, так как все используемые Activity должны быть явно объявлены в манифесте.

6. **Какие методы жизненного цикла Activity вызываются при переходе от MainActivity к SettingsActivity и при возврате обратно?**

   **При переходе от MainActivity к SettingsActivity:**
   - MainActivity: `onPause()`
   - SettingsActivity: `onCreate()`, `onStart()`, `onResume()`
   - MainActivity: `onStop()`

   **При возврате обратно:**
   - SettingsActivity: `onPause()`
   - MainActivity: `onRestart()`, `onStart()`, `onResume()`
   - SettingsActivity: `onStop()`, `onDestroy()`

7. **Для чего используется requestCode в методе startActivityForResult()? Как обрабатываются несколько различных запросов в onActivityResult()?**

   `requestCode` — уникальный целочисленный идентификатор запроса. Он позволяет различать, из какой Activity пришёл результат, когда родительская Activity запускает несколько дочерних Activity с ожиданием результата.

   В методе `onActivityResult()` проверяется `requestCode` с помощью условных операторов (if или switch), чтобы определить, какой результат обрабатывать, и соответственно извлечь данные.

   ```java
   @Override
   protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       super.onActivityResult(requestCode, resultCode, data);
       if (requestCode == REQUEST_CODE_SETTINGS) {
           // Обработка результата из настроек
       } else if (requestCode == REQUEST_CODE_PROFILE) {
           // Обработка результата из профиля
       }
   }
   ```
