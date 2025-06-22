<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>List of books</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Description</th>
            <th scope="col">Author</th>
            <th scope="col">Release year</th>
            <th scope="col">Is borrowed?</th>

        </tr>
        </thead>
        <tbody class="table-group-divider">
        <#if book?? >
            <tr>
                <th scope="row">${book.name}</th>
                <td>${book.description}</td>
                <td>${book.author}</td>
                <td>${book.releaseYear}</td>
                <td>
                    <#if book.borrowedBy??>
                        ${book.borrowed.name}
                    <#else>
                        Not
                    </#if>
                </td>
            </tr>
        </#if>
        </tbody>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js" integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q" crossorigin="anonymous"></script>
</body>
</html>