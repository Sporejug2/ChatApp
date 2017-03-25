<html lang="hr">
<head>
    <meta charset="UTF-8">
    <title>Evidencija prijavljenih</title>
    <style>
        input, textarea { display: block; }
    </style>
</head>
<body>
<h1> Brisanje odgovora koje si poslao korisnicima </h1>

    <?php
    include "spoj.php";
    
    $sql_upit="SELECT * FROM admin_answer ORDER BY id ASC";
    if(!$q=mysql_query($sql_upit))
    {
    echo "Nismo uspjeli učitati korisnike iz baze"."<br>".mysql_query();
    die();
    }
    //ako je broj redaka nula onda nema studenata u bazi
    if(mysql_num_rows($q)==0)
    {
        echo"Nema korisnikau bazi.";
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
            echo '<td><a href="izmjenipp.php?id='.$redak["id"].'">Uredi korisnika</a></td>';
            echo '<td><a href="obrisipp.php?brisanje=brisi&id='.$redak["id"].'">Obriši</a></td>
                 </tr>';
        }
        echo '</table>';
        }
        ?>


   <h3><a href="register_test.php">Odgovori na primljene poruke</a> </h3>     
    
   <h3><a href="LoginZaAdmine.php">Povratak na evidenciju registriranih korisnika</a></h3>
   
   <h3><a href="Zahtjev.php">Zahtjev</a></h3>
   
   <h4><a href="mojRaspored.php">Moj raspored</a> </h4>  
   

   </body>
   </html>