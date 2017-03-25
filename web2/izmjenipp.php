<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div>TODO write content</div>
        
        <h1>Izmjena unesenih podataka</h1>
        
        <?php
        include "spoj.php";
        if(!$_POST["spremanje"])
        {
            $doslo_do_greske=false;
        if(!$_GET["id"])
        {
            echo"Doslo je do pogreske u pribavljanju korisničkog id-a";
           $doslo_do_greske=true;
        }
        else{
        $sql_upit="SELECT * FROM admin_answer WHERE id=".$_GET["id"];
        if(!$q=mysql_query($sql_upit))
        {
        echo"Nastala je greska pri trazenju korisnika<br>".mysql_error();
        $doslo_do_greske=true;
        }
        elseif(mysql_num_rows($q)==0)
        {
       echo"nema trazenog korisnika.";
       $doslo_do_greske=true;
        } else {
        $student=mysql_fetch_array($q);    
        }
        }
        if(!$doslo_do_greske)
        {
            ?>
        <form action="" method="post">
            <table>
                <tr>
                    <input type="hidden" name="id" value="<?php echo $_GET["id"];?>">
                    <td>Name : </td><td><input type="text" name="name" value="<?php echo $student["name"]?>"></td>
                </tr>
                
                <tr>
                    <td>Time: </td><td><input type="text" name="time" value="<?php echo $student["time"]?>"></td>
                </tr>
                
                <tr>
                    <td>Message : </td><td><input type="text" name="message"value="<?php echo $student["message"]?>"></td>
                </tr>
               
                
                <tr>
                    <td><input type="submit" name="spremanje" value="Spremi"/></td>
                </tr>
            </table>
            
        </form>
        
        <?php
        }
        }else{
            $sql_update="UPDATE admin_answer SET
                    name='".$_POST["name"]."',
                    time='".$_POST["time"]."',
                    message='".$_POST["message"]."'WHERE id=".$_POST["id"];
                   
                    
                    if(mysql_query($sql_update)){
                        if(mysql_affected_rows()>0){
                            echo"pohranili smo izmjene o studentu.";
                        }else{
                            echo"Nismo uspjeli izmjeniti podatke o studentu.";
                        }
                    }else{
                            echo"Nastala je greska pri upisivanju podataka u bazu.".mysql_error();
                        }
                    }
                ?>
        <hr>
         <h3><a href="LoginZaAdmine.php">Povratak na evidenciju registriranih korisnika</a></h3>
        <h3><a href="ispispp.php">Povratak na ispis</a></h3>
        
        <hr>
    </body>
</html>

