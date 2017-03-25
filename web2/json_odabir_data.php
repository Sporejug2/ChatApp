<?php

$db_name = "app";
$mysql_user = "root";
$mysql_pass = "";
$server_name = "localhost";

$sql = "select * from mjesta;";

$con = mysqli_connect($server_name, $mysql_user, $mysql_pass, $db_name);

$result = mysqli_query($con, $sql);

$response = array();

while($row = mysqli_fetch_array($result))
{
    array_push($response,array("id"=>$row[0],"state"=>$row[1],"city"=>$row[2],"name"=>$row[3]));
    
}

echo json_encode(array("server_response"=>$response));

mysqli_close($con);
 
?>

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

