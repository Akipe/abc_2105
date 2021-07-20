<?php
declare(strict_types = 1);

namespace abc2105\basket_app\fruit;

use abc2105\basket_app\Fruit;

class Pear extends Fruit {
    private string $color;

    public function getColor(): string
    {
        // ...
    }

    public function setColor(string $color): void
    {
        // ...
    }
}