<?php

namespace app\models;

use yii\db\ActiveRecord;

class UserModel extends ActiveRecord
{
    public static function tableName()
    {
        return 'user';
    }
}
