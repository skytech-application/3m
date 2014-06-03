<h2>The authentic mog mog manager project ;)</h2>
<hr>
<ul>
<li>Spring 4</li>
<li>Hibernate 3</li>
<li>Log4J</li>
<li>JUnit 4</li>
<li>HSQLDB (for test cases)</li>
<li>Technical and functional exception handler with JSON response</li>
<li>MySQL</li>
</ul>

<h2> Example : </h2>

<pre>
	<code>http://localhost:8080/mogmogmanager/api/users/9</code>
	Returns : {"id":9,"username":"User 9"}
</pre>

<pre>
	<code>http://localhost:8080/mogmogmanager/api/users/</code>
	Returns : [{"id":1,"username":"User 1"},{"id":2,"username":"User 2"},{"id":3,"username":"User 3"},{"id":4,"username":"User 4"},{"id":5,"username":"User 5"},{"id":6,"username":"User 6"},{"id":7,"username":"User 7"},{"id":8,"username":"User 8"},{"id":9,"username":"User 9"},{"id":10,"username":"User 10"}]
</pre>

<pre>
	<code>http://localhost:8080/mogmogmanager/api/users/id/1</code>
	Returns : {"id":1,"username":"User 1"}
</pre>

<pre>
	<code>http://localhost:8080/mogmogmanager/api/users/username/User 1</code>
	Returns : {"id":1,"username":"User 1"}
</pre>

<pre>
	<code>http://localhost:8080/mogmogmanager/api/users/username/anything</code>
	Returns : {"code":"Technical error : ","message":"Impossible de find user by username : anything"}
</pre>

<pre>
	<code>http://localhost:8080/mogmogmanager/api/users/id/-4</code>
	Returns : {"code":"Functional error : ","message":"ID must be positive"}
</pre>

And many others... 

contact : skytech.application@gmail.com