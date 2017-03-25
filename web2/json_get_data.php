<?php

$db_name = "app";
$mysql_user = "root";
$mysql_pass = "";
$server_name = "localhost";

$sql = "select * from user_call;";

$con = mysqli_connect($server_name, $mysql_user, $mysql_pass, $db_name);

$result = mysqli_query($con, $sql);

$response = array();

while($row = mysqli_fetch_array($result))
{
    array_push($response,array("id"=>$row[0],"name"=>$row[1],"time"=>$row[2],"poruka"=>$row[3]));
    
}

echo json_encode(array("server_response"=>$response));

mysqli_close($con);
 
?>