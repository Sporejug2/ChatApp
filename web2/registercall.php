<?php
error_reporting(0);
require "init.php";
 
$name = $_POST["name"];
$time = $_POST["time"];
$message = $_POST["message"];
 
//$name = "sdf";
//$time = "13:00";
//$message = "dolazim ili pucam";
 
$sql = "INSERT INTO `user_call` (`id`,`name`, `time`, `message`) VALUES (NULL, '".$name."', '".$time."', '".$message."');";
if(!mysqli_query($con, $sql)){
    echo '{"message":"Unable to save the data to the database."}';
}
 
?>

