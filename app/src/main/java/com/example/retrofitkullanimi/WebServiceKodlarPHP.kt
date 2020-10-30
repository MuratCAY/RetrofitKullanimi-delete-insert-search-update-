package com.example.retrofitkullanimi

/*
db_config************

<?php
define('DB_USER', "u139539474_root");
define('DB_PASSWORD', "123456");
define('DB_DATABASE', "u139539474_movie");
define('DB_SERVER', "mysql.hostinger.web.tr");
?>


delete_kisiler**************

<?php
$response = array();

if (isset($_POST['kisi_id'])) {
    $kisi_id = $_POST['kisi_id'];

    //DB_SERVER,DB_USER,DB_PASSWORD,DB_DATABASE değişkenleri alınır.
    require_once __DIR__ . '/db_config.php';

    // Bağlantı oluşturuluyor.
    $baglanti = mysqli_connect(DB_SERVER, DB_USER, DB_PASSWORD, DB_DATABASE);

    // Bağlanti kontrolü yapılır.
    if (!$baglanti) {
        die("Hatalı bağlantı : " . mysqli_connect_error());
    }
    $sqlsorgu = "DELETE FROM kisiler WHERE kisiler.kisi_id = $kisi_id";

    if (mysqli_query($baglanti, $sqlsorgu)) {

        $response["success"] = 1;
        $response["message"] = "successfully ";
        echo json_encode($response);
    } else {

        $response["success"] = 0;
        $response["message"] = "No product found";
        echo json_encode($response);
    }
    //bağlantı koparılır.
    mysqli_close($baglanti);
} else {
    $response["success"] = 0;
    $response["message"] = "Required field(s) is missing";
    echo json_encode($response);
}
?>

insert_kisiler***************************

<?php
$response = array();

if (isset($_POST['kisi_ad']) && isset($_POST['kisi_tel'])) {
    $kisi_ad = $_POST['kisi_ad'];
    $kisi_tel = $_POST['kisi_tel'];

    //DB_SERVER,DB_USER,DB_PASSWORD,DB_DATABASE değişkenleri alınır.
    require_once __DIR__ . '/db_config.php';

    // Bağlantı oluşturuluyor.
    $baglanti = mysqli_connect(DB_SERVER, DB_USER, DB_PASSWORD, DB_DATABASE);

    // Bağlanti kontrolü yapılır.
    if (!$baglanti) {
        die("Hatalı bağlantı : " . mysqli_connect_error());
    }

    $sqlsorgu = "INSERT INTO kisiler (kisi_ad,kisi_tel) VALUES ('$kisi_ad','$kisi_tel')";

    if (mysqli_query($baglanti, $sqlsorgu)) {
        $response["success"] = 1;
        $response["message"] = "successfully ";
        echo json_encode($response);
    } else {
        $response["success"] = 0;
        $response["message"] = "No product found";
        echo json_encode($response);
    }
    //bağlantı koparılır.
    mysqli_close($baglanti);
} else {
    $response["success"] = 0;
    $response["message"] = "Required field(s) is missing";
    echo json_encode($response);
}
?>



tum_kisiler********************

<?php
// array for JSON response
$response = array();

//DB_SERVER,DB_USER,DB_PASSWORD,DB_DATABASE değişkenleri alınır.
require_once __DIR__ . '/db_config.php';

// Bağlantı oluşturuluyor.
$baglanti = mysqli_connect(DB_SERVER, DB_USER, DB_PASSWORD, DB_DATABASE);

// Bağlanti kontrolü yapılır.
if (!$baglanti) {
    die("Hatalı bağlantı : " . mysqli_connect_error());
}

$sqlsorgu = "SELECT * FROM kisiler";
$result = mysqli_query($baglanti, $sqlsorgu);

// result kontrolü yap
if (mysqli_num_rows($result) > 0) {

    $response["kisiler"] = array();

    while ($row = mysqli_fetch_assoc($result)) {
        // temp user array
        $kisiler = array();

        $kisiler["kisi_id"] = $row["kisi_id"];
        $kisiler["kisi_ad"] = $row["kisi_ad"];
        $kisiler["kisi_tel"] = $row["kisi_tel"];

        // push single product into final response array
        array_push($response["kisiler"], $kisiler);
    }
    // success
    $response["success"] = 1;

    // echoing JSON response
    echo json_encode($response);

} else {
    // no products found
    $response["success"] = 0;
    $response["message"] = "No data found";

    // echo no users JSON
    echo json_encode($response);
}
//bağlantı koparılır.
mysqli_close($baglanti);
?>


tum_kisiler_arama**********************

<?php

    $response = array();

    if (isset($_POST['kisi_ad'])) {
        $kisi_ad = $_POST['kisi_ad'];

        //DB_SERVER,DB_USER,DB_PASSWORD,DB_DATABASE değişkenleri alınır.
        require_once __DIR__ . '/db_config.php';

        // Bağlantı oluşturuluyor.
        $baglanti = mysqli_connect(DB_SERVER, DB_USER, DB_PASSWORD, DB_DATABASE);

        // Bağlanti kontrolü yapılır.
        if (!$baglanti) {
            die("Hatalı bağlantı : " . mysqli_connect_error());
        }

        $sqlsorgu = "SELECT * FROM kisiler WHERE kisiler.kisi_ad like '%$kisi_ad%'";
        $result = mysqli_query($baglanti, $sqlsorgu);

        if (mysqli_num_rows($result) > 0) {

            $response["kisiler"] = array();

            while ($row = mysqli_fetch_assoc($result)) {

                $kisiler = array();

                $kisiler["kisi_id"] = $row["kisi_id"];
                $kisiler["kisi_ad"] = $row["kisi_ad"];
                $kisiler["kisi_tel"] = $row["kisi_tel"];

                array_push($response["kisiler"], $kisiler);
            }

            $response["success"] = 1;
            echo json_encode($response);
        }
        //bağlantı koparılır.
        mysqli_close($baglanti);
    } else {
        $response["success"] = 0;
        $response["message"] = "Required field(s) is missing";
        echo json_encode($response);
}
?>




update_kisiler*******************

<?php

$response = array();

    if (isset($_POST['kisi_id']) && isset($_POST['kisi_ad']) && isset($_POST['kisi_tel']) ) {
        $kisi_id = $_POST['kisi_id'];
        $kisi_ad = $_POST['kisi_ad'];
        $kisi_tel = $_POST['kisi_tel'];

        //DB_SERVER,DB_USER,DB_PASSWORD,DB_DATABASE değişkenleri alınır.
        require_once __DIR__ . '/db_config.php';

        // Bağlantı oluşturuluyor.
        $baglanti = mysqli_connect(DB_SERVER, DB_USER, DB_PASSWORD, DB_DATABASE);

        // Bağlanti kontrolü yapılır.
        if (!$baglanti) {
            die("Hatalı bağlantı : " . mysqli_connect_error());
        }

        $sqlsorgu = "UPDATE kisiler SET kisiler.kisi_ad = '$kisi_ad',kisiler.kisi_tel = '$kisi_tel' WHERE kisiler.kisi_id = $kisi_id  ";

    if (mysqli_query($baglanti, $sqlsorgu)) {
        $response["success"] = 1;
        $response["message"] = "successfully ";
        echo json_encode($response);
    } else {
        $response["success"] = 0;
        $response["message"] = "No product found";
        echo json_encode($response);
    }
        //bağlantı koparılır.
        mysqli_close($baglanti);
} else {
    $response["success"] = 0;
    $response["message"] = "Required field(s) is missing";
    echo json_encode($response);
}
?>




 */

