<?php

/*
 * Buat pendaftaran baru
 */

$response = array();

// cek form
if (isset($_POST['nama_pemesan']) && isset($_POST['alamat']) && isset($_POST['nama_produk']) && isset($_POST['ukuran']) && isset($_POST['harga']) && isset($_POST['jumlah']) && isset($_POST['total_harga'])) {
    
    $nama_pemesan = $_POST['nama_pemesan'];
    $alamat = $_POST['alamat'];
    $nama_produk = $_POST['nama_produk'];
    $ukuran = $_POST['ukuran'];
    $harga = $_POST['harga'];
    $jumlah = $_POST['jumlah'];
    $total_harga = $_POST['total_harga'];

    // include db connect
    require_once __DIR__ . '/db_connect.php';

    // konekin db
    $db = new DB_CONNECT();

    // insert ke db
    $result = mysql_query("INSERT INTO pesanan(nama_pemesan, alamat, nama_produk, ukuran, harga
        , jumlah, total_harga) 
    VALUES('$nama_pemesan', '$alamat', '$nama_produk', '$ukuran', '$harga', '$jumlah', '$total_harga')");

    // cek data udah masuk belum
    if ($result) {
        // kalo sukses
        $response["success"] = 1;
        $response["message"] = "Pendaftaran anda berhasil";

        // echoing JSON response
        echo json_encode($response);
    } else {
        // fkalo gagal
        $response["success"] = 0;
        $response["message"] = "Sistem mendeteksi kesalahan, silahkan coba lagi";
        
        // echoing JSON response
        echo json_encode($response);
    }
} else {
    $response["success"] = 0;
    $response["message"] = "Silahkan lengkapi aksi sebelum memulai permintaan anda";

    // echoing JSON response
    echo json_encode($response);
}
?>
