<?php
declare(strict_types = 1);

namespace abcd2105\basket_app;

use abcd2105\basket_app\Fruit;

class Customer
{
    private int $clientid;
    private Fruit $sample;
    private array $items;


    public function __construct(int $clientid)
    {
        // ...
    }

    public function getClientId(): int
    {
        // ...
    }
}