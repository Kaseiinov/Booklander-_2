<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Profile</title>
</head>
<body>
<div class="container">
    <h1 class="text-center">User profile</h1>

    <div class="card mt-4">
        <div class="card-body">
            <h4 class="card-title">User email -> <b>${user.email!"User email"}</b></h4>
            <h6 class="card-subtitle mb-2 ">User first name -> <b>${user.firstName!"User firstName"}</b></h6>
            <h6 class="card-subtitle mb-2 ">User last name -> <b>${user.lastName!"User lastName"}</b></h6>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>