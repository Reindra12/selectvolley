<?php

function send_notification($message) {
    $tokens = 'dDtkvXuuRaiqtU2OKhioYy:APA91bFdlRswsjUHIZlYb6IBY-z4S9a5s5vBkAQGtDYAdJA-GfBoI4IIdh6Ni3W1zr5tm4LEpK-fmSsSumQJrhOmxiloQDtboidQvFpaG_Mf8RHnlR9R60zi2qwxmlY4EUI23AXWInRM';
    // $message = 'Pesan ini mengandung bahaya';

    $url = 'https://fcm.googleapis.com/fcm/send';
    $fields = array(
        // for token
        // 'to' => $tokens,  

        //for topics
        'to' => '/topics/monitoring',
        'data' => $message
    );

    $headers = array(
        'Authorization:key = AAAAfSXmvqQ:APA91bFof9HJZlRr__cxb_mVSc0NNjLi4MzAuXauQG9_ElIW2JAUVDJsF5t8TTgja-l80rNpMk6We41kUf1T-6J9wqmAjxw6lI1R1MbrDybtmMRSDoDEVNbeADyAOlXcLVo8u5hrB713',
        'Content-Type: application/json'
    );

    $ch = curl_init();
    curl_setopt($ch, CURLOPT_URL, $url);
    curl_setopt($ch, CURLOPT_POST, true);
    curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
    curl_setopt($ch, CURLOPT_SSL_VERIFYHOST, 0);
    curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);
    curl_setopt($ch, CURLOPT_POSTFIELDS, json_encode($fields));

    $result = curl_exec($ch);
    if ($result === FALSE) {
        die('Curl failed: ' . curl_error($ch));
    }

    curl_close($ch);
    return $result;
}

// $conn = mysqli_connect("localhost","root","","monitoring_mahasiswa");
// $sql = "select token from users";
// $result = mysqli_query($conn,$sql);
// $tokens = array();

// if(mysqli_num_rows($result) > 0 ){
//     while ($row = mysqli_fetch_assoc($result)) {
//         $tokens[] = $row["token"];
//     }
// }

// mysqli_close($conn);
include 'dbconfig.php';
$message = array("message" => "Test push notification message!");
$message_status = send_notification($message);
echo $message_status;

?>
