<!DOCTYPE html>
<html>
<head><title>Bank Transfer</title></head>
<body>
    <h2>Money Transfer (with Commit & Rollback)</h2>
    <form action="transfer" method="post">
        From Account: <input type="number" name="from" required><br><br>
        To Account: <input type="number" name="to" required><br><br>
        Amount: <input type="number" name="amount" required><br><br>
        <input type="submit" value="Transfer Money">
    </form>
</body>
</html>
