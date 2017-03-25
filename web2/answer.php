<?php
error_reporting(0);
require 'spoj.php';

$name = $_POST("name");
$time = $_POST("time");
$message = $_POST("message");

$sql = "INSERT INTO ``admin_answer` (`id`,`name`, `time`, `message`) VALUES (NULL, '".$name."', '".$time."', '".$message."');";

if(!mysqli_query($con, $sql)){
    echo ' { message" : Unable to save the data to database."}';
}

echo 'poruka je poslana';
?>

