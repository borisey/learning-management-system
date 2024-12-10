<?php

return [
    'class' => 'yii\db\Connection',
    'dsn' => 'mysql:host=user_db;port=3306;dbname=user_db',
//    'dsn' => 'mysql:host=127.0.0.1;port=3306;dbname=user_db',
    'username' => 'root',
    'password' => 'root',
    'charset' => 'utf8',

    // Schema cache options (for production environment)
    //'enableSchemaCache' => true,
    //'schemaCacheDuration' => 60,
    //'schemaCache' => 'cache',
];
