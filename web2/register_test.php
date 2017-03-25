<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        
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
    $sql_forma="INSERT INTO admin_answer(name,time,message)
      VALUES('$_POST[name]','$_POST[time]','$_POST[message]')";      
    
    //projera jesu li podatci uspješno upisani
    if(mysql_query($sql_forma))
    {
        echo 'Pohranili smo podatke o studentu. <br>';
        echo 'idi na ispis poslanih poruka:<a href="ispis_pp.php>Uredi studenta</a>';
        
    }
    else{
        echo 'Nismo pohranili podatke o studentu'."<br>".mysql_error();
       
    }
    }
    ?>
        
    </body>
</html>
