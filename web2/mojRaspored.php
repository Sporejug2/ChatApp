<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        
        <h3>Moj raspored :-!</h3>
        
        <?php
    
    if(!$_POST["spremanje"])
    {
    ?>
        
        <form action="" method="post">
            <table>
                <tr>
                    <td>Name : </td><td><input type="text" name="name"/></td>
                </tr>
                
                <tr>
                    <td>Time: </td><td><input type="text" name="time"/></td>
                </tr>
                
                <tr>
                    <td>Message : </td><td><input type="text" name="message"/></td>
                </tr>
               
                <tr>
                    <td><input type="submit" name="spremanje" value="Spremi"/></td>
                </tr>
            </table>
            
        </form>
        
        <h2><a href="ispispp.php">Ispis poslanih poruka</a></h2>
       <?php
    }
 else 
    {
//poziv skripte za spoj na mysql
    include 'spoj.php';
    $sql_forma="INSERT INTO dnevni_raspored(name,time,message)
      VALUES('$_POST[name]','$_POST[time]','$_POST[message]')";      
    
    //projera jesu li podatci uspješno upisani
    if(mysql_query($sql_forma))
    {
        echo 'Pohranili smo podatke o korisniku. <br>';
        
        
    }
    else{
        echo 'Nismo pohranili podatke o korisniku'."<br>".mysql_error();
       
    }
    }
    
    ?>
        
         <?php
    include "spoj.php";
    
    $sql_upit="SELECT * FROM dnevni_raspored ORDER BY id ASC";
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
        
    </body>
</html>


