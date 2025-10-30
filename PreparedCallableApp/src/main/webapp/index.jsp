<!DOCTYPE html>
<html>
<head><title>Student Entry</title></head>
<body>
    <h2>Insert Student using PreparedStatement</h2>
    <form action="db" method="post">
        ID: <input type="number" name="id" required><br><br>
        Name: <input type="text" name="name" required><br><br>
        Dept: <input type="text" name="dept" required><br><br>
        <input type="submit" value="Insert">
    </form>

    <br>
    <form action="show.jsp">
        <input type="submit" value="Show All Students (Callable)">
    </form>
</body>
</html>
