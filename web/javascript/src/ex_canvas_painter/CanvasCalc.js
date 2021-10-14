class CanvasCalc {
    // constructor(canvasElement) {
    //     this.canvasElement = canvasElement;
    //     this.canvasContext = canvasElement.getContext('2d');
    // }

    isPointIsOnSegment(_pointX, _pointY, _firstEndSegmentX, _firstEndSegmentY, _secondEndSegmentX, _secondEndSegmentY, _averagePercentErrorAuthorized)
    {
        let segmentSize;
        let segmentPointToFirstEndSize;
        let segmentPointToSecondEndSize;
        let sumTwoSegmentsPointsFirstSecond;
        let sumTwoSegmentsPointsFirstSecondAverageMinnor;
        let sumTwoSegmentsPointsFirstSecondAverageMajor;
        
        segmentSize = Math.hypot(
            _secondEndSegmentX - _firstEndSegmentX,
            _secondEndSegmentY - _firstEndSegmentY
        );
        segmentPointToFirstEndSize = Math.hypot(
            _firstEndSegmentX - _pointX,
            _firstEndSegmentY - _pointY
        );
        segmentPointToSecondEndSize = Math.hypot(
            _secondEndSegmentX - _pointX,
            _secondEndSegmentY - _pointY
        );

        sumTwoSegmentsPointsFirstSecond = segmentPointToFirstEndSize + segmentPointToSecondEndSize;
        sumTwoSegmentsPointsFirstSecondAverageMajor = sumTwoSegmentsPointsFirstSecond + (sumTwoSegmentsPointsFirstSecond * _averagePercentErrorAuthorized);
        sumTwoSegmentsPointsFirstSecondAverageMinnor = sumTwoSegmentsPointsFirstSecond - (sumTwoSegmentsPointsFirstSecond * _averagePercentErrorAuthorized);

        if (segmentSize <= sumTwoSegmentsPointsFirstSecondAverageMajor && segmentSize >= sumTwoSegmentsPointsFirstSecondAverageMinnor) {
            console.log("It's true!");
            return true;
        } else {
            console.log("It's false!");
            return false;
        }
    }
}