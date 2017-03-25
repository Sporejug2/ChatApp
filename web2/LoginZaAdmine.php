<?php

    session_start();

    if( isset($_POST['username']) && $_POST['username'] == 'frizerka' &&
        isset($_POST['password']) && $_POST['password'] == 'frizerka123'
    ) {
        $_SESSION['is_logged_in'] = true;
    }

?>

<!DOCTYPE html>
<html lang="hr">
<head>
    <meta charset="UTF-8">
    <title>Login example</title>
    <style>
        input, textarea { display: block; }
    </style>
</head>
<body>
    <?php if(isset($_SESSION['is_logged_in']) && $_SESSION['is_logged_in']): ?>

   
        <h1> Evidencija registriranih korisnika </h1>
    <?php
    include "spoj.php";
    
    $sql_upit="SELECT * FROM user_info ORDER BY id ASC";
    if(!$q=mysql_query($sql_upit))
    {
    echo "Nismo uspjeli učitati studente iz baze"."<br>".mysql_query();
    die();
    }
    //ako je broj redaka nula onda nema studenata u bazi
    if(mysql_num_rows($q)==0)
    {
        echo"Nema studenata u bazi.";
    }
    else{
        echo '<table width="1000" border="1px" cellpadding="2" cellspacing="2">';
        echo '<tr><td><b>id</b></td>';
        echo '<td><b>name</b></td>';
        echo '<td><b>password</b></td>';
        echo '<td><b>email</b></td></tr>';
        
        //sve dok ima studenata u bazi
        while ($redak=mysql_fetch_array($q))
        {
            echo '<tr><td><b>'.$redak["id"].'</td>';
            echo '<td><b>'.$redak["name"].'</b></td>';
            echo '<td><b>'.$redak["password"].'</b></td>';
            echo '<td><b>'.$redak["email"].'</b></td></tr>';
            echo '<td><b><a href="izmjeni.php?id='.$redak["id"].'">Uredi korisnika</a></b></td>';
            echo '<td><b><a href="obrisi.php?brisanje=brisi&id='.$redak["id"].'">Obriši</a></b></td></tr>';
        }
        echo '</table>';
        }
        ?>
        <h2> Pritisnite logout za izlazak</h2>
          <?php if($_GET['logout']==1) session_destroy(); ?>
        <a href="?logout=1">Logout</a>
        <br>
        <a href="Zahtjev.php"> Pregledati dolazne zahtjeve</a>

    <?php else: ?>
        
        <form method="post">

            <label for="username">Username</label>
            <input type="text" id="username" name="username" required />

            <label for="password">Password</label>
            <input type="text" id="password" name="password" required />

            <button type="submit">Login</button>

        </form>

    <?php endif ?>

</body>
</html>

