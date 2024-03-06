<h1>Запуск</h1>
<p>Для запуска используйте <b><i>intervals.jar</i></b> в корневой директории приложения.<br>Для корректной работы необходима версия java не ниже <b>17</b>.</p>
<h1>Запросы</h2>
<p>У всех эндпоинтов <b>обязательно</b> должен быть указан параметр <b><i>kind</i></b>, принимающий значения <b><i>digits</i></b> или <b><i>letters</i></b> для чисел или букв соответственно.</p>
<h3>POST</h3>
<p>Добавление интервалов - <i>/api/v1/intervals/merge</i></p>
<p>Необходимо указать тело запроса, представляющее собой массив с интервалами чисел или букв для digits или letters соответственно. Интервалы представляют собой массив из двух элементов. Второй элемент должен быть не меньше первого.</p>
<p>При успешном выполнении запроса приложение вернет обработанные интервалы.</p>
<p>При возникновении ошибок валидации приложение вернет ответ в виде <b>400</b> статус кода с деталями ошибки.</p>
<h2>GET</h2>
<p>Запрос минимального интервала - <i>/api/v1/intervals/min</i></p>
<p>При успешной обработке запроса приложение вернет минимальный интервал.</p>
<p>В том случае, если минимального интревала не оказалось приложение вернет <b>204</b> статус код.</p>
<h1>О проекте</h1>
<b>Версия JDK:</b> 17 <br>
<b>Система сборки:</b> Maven (Model Version 4.0.0) <br>
