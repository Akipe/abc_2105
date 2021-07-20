<?php
declare(strict_types = 1);

namespace abcd2105\basket_app;

class Fruit
{
    private string $label;
    private float $price;


    public function getLabel(): string
    {
        // ...
    }

    public function getPrice(): float
    {
        // ...
    }

    public function setPrice(float $price): void
    {
        // ...
    }
}