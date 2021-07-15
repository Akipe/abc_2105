package poo.cardgame.composants.helper;

import java.util.Arrays;

public class AkpArrays {
    
    public static Object[] removeObject(Object[] _arrayObjects, Object _objectToRemove)
    {
        Object[] arrayWithRemoveObject = new Object[_arrayObjects.length - 1];

        for (int indexOldTab = 0, indexNewTab = 0; indexOldTab < _arrayObjects.length; indexOldTab++) {

            if (_arrayObjects[indexOldTab].equals(_objectToRemove)) {
                indexNewTab--;
            } else {
                arrayWithRemoveObject[indexNewTab] = _arrayObjects[indexOldTab];
            }

            indexNewTab++;
        }

        return arrayWithRemoveObject;
    }

    public static Object[] appendObject(Object[] _arrayObjects, Object _objectToAdd)
    {
        _arrayObjects = Arrays.copyOf(_arrayObjects, _arrayObjects.length + 1);
        _arrayObjects[_arrayObjects.length - 1] = _objectToAdd;

        return _arrayObjects;
    }
}
