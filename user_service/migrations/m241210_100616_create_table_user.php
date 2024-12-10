<?php

use yii\db\Migration;

/**
 * Class m241210_100616_create_table_user
 */
class m241210_100616_create_table_user extends Migration
{
    const TABLE = 'user';

    const USERS = [
        ['admin'], ['test_user_1'], ['test_user_2'], ['test_user_3'],
    ];

    /**
     * {@inheritdoc}
     */
    public function safeUp()
    {
        $this->createTable(self::TABLE, [
            'id'       => $this->primaryKey(),
            'username' => $this->string(255),
        ]);

        $this->batchInsert(self::TABLE, ['username'], self::USERS);
    }

    /**
     * {@inheritdoc}
     */
    public function safeDown()
    {
        $this->dropTable(self::TABLE);
    }
}
