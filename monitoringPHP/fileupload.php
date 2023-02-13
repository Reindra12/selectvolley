<?php
include 'dbconfig.php'; // include database connection file


    
	//    $name=$_POST['t1'];
	//    $design=$_POST['t2'];	   
	//    $img=$_POST['name'];
$img = isset($_POST['name']) ? $_POST['name'] : '';
$foto="IMG".rand().".jpg";

$tglm = isset($_POST['tglm']) ? $_POST['tglm'] : '';
$nis = isset($_POST['nis']) ? $_POST['nis'] : '';
$jam = isset($_POST['jam']) ? $_POST['jam'] : '';
$kegiatan = isset($_POST['kegiatan']) ? $_POST['kegiatan'] : '';
$lokasi = isset($_POST['lokasi']) ? $_POST['lokasi'] : '';
$user = isset($_POST['user']) ? $_POST['user'] : '';
// $foto = isset($_POST['foto']) ? $_POST['foto'] : '';

if(empty($foto) || empty($tglm) || empty($nis) || empty($jam) || empty($kegiatan) || empty($lokasi) || empty($user)		
){
	$errorMSG = json_encode(array("message" => "lengkapi data anda", "status" => false));	
	echo $errorMSG;

}else{	   
	   file_put_contents("upload/".$foto,base64_decode($img));

	   $query = mysqli_query($conn,'INSERT into tbl_image (name,tgl,nis,jam,kegiatan,lokasi,user) VALUES("'.$foto.'","'.$tglm.'","'.$nis.'","'.$jam.'","'.$kegiatan.'","'.$lokasi.'","'.$user.'")');
	
	   echo json_encode(array("message" => "Image Uploaded Successfully", "status" => true));	
}   
?>
