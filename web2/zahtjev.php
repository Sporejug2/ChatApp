<html lang="hr">
<head>
    <meta charset="UTF-8">
    <title>Evidencija prijavljenih</title>
    <style>
        input, textarea { display: block; }
    </style>
</head>
<body>

    <h1> Naručivanje klijenata kod frizera </h1>

    <?php
    include "spoj.php";
    
    if($_GET["brisanje"]=="brisi")
    {
        $sql_brisi="DELETE FROM user_call WHERE id=".$_GET["id"];
    }
    if(mysql_query($sql_brisi))
    {
        echo " Uspješno ste obrisali zahtjev korisnika";
    }
 else {
        echo 'NIste uspjesno obrisali zahtjev korisnika."."<br>'.mysql_error();        
}


    $sql_upit="SELECT * FROM user_call ORDER BY id ASC";
    if(!$q=mysql_query($sql_upit))
    {
    echo "Nismo uspjeli učitati zahtjeve korisnika iz baze"."<br>".mysql_query();
    die();
    }
    //ako je broj redaka nula onda nema studenata u bazi
    if(mysql_num_rows($q)==0)
    {
        echo"Nema korisnika u bazi.";
    }
    else{
        echo '<table width="1000" border="1px" cellpadding="2" cellspacing="2" >';
       echo '<tr><td><b>id</b></td>';
        echo '<td><b>name</b></td>';
        echo '<td><b>time</b></td>';
        echo '<td><b>message</b></td></tr>';
        
        //sve dok ima studenata u bazi
        while ($redak=mysql_fetch_array($q))
        {
            echo '<tr><td><b>'.$redak["id"].'</td>';
            echo '<td>'.$redak["name"].'</td>';
            echo '<td>'.$redak["time"].'</td>';
            echo '<td>'.$redak["message"].'</td>';
          //  echo '<td><a href="izmjeni.php?id='.$redak["id"].'">Uredi studenta</a></td>';
             echo '<td><a href="zahtjev.php?brisanje=brisi&id='.$redak["id"].'">Obriši</a></td>
                 </tr>';
        }
        echo '</table>';
        }
        ?>
    <h3
   <h3><a href="LoginZaAdmine.php">Povratak na evidenciju registriranih korisnika</a></h3>
        
  
   <h3><a href="ispispp.php">Odgovori koje si poslao korisniku</a></h4>
   
</body>
</html>

