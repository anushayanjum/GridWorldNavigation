public class PathFinder {
  private final GridWorld gridWorld;
  private final Move[][] previousMoveData;
    
  public PathFinder(GridWorld gridWorld) {
    this.gridWorld = gridWorld;
    this.previousMoveData = new Move[gridWorld.getRowCount()][gridWorld.getColCount()];
  }

  // Return a list of moves to get from the starting point of the grid to the ending
  public SinglyLinkedList<Move> findShortestPath() {
    GridIndex start = gridWorld.getStartingPoint();
    GridIndex end = gridWorld.getEndingPoint();

    // Create queue and enqueue the starting node
    Queue<GridIndex> queue = new LinkedQueue<GridIndex>();
    queue.enqueue(start);

    // Start BFS, continue until all grid spaces are explored (queue empty)
    while (!queue.isEmpty()) {
      GridIndex current = queue.dequeue();

      // Check moves in all cardinal directions and see what works
      Move[] moves = {Move.UP, Move.DOWN, Move.LEFT, Move.RIGHT};
      for (Move m : moves) {
        GridIndex next = gridWorld.tryMove(current, m);

        // Valid move AND not cycle AND not the starting point
        if (next != null && !gridWorld.isBlocked(next) && previousMoveData[next.row][next.col] == null && !gridWorld.isStartingPoint(next)) {
          previousMoveData[next.row][next.col] = m;

          // if end found, stop the program
          if (gridWorld.isEndingPoint(next)) {
            queue = new LinkedQueue<GridIndex>();
            break;
          }

          queue.enqueue(next);
        }
      }
    }

    // If no path then return null
    if (previousMoveData[end.row][end.col] == null) {
      return null;
    }

    // Otherwise, reconstruct the path by walking backwards
    SinglyLinkedList<Move> path = new SinglyLinkedList<>();
    GridIndex current = end;
    while (!gridWorld.isStartingPoint(current)) {
        Move taken = previousMoveData[current.row][current.col];
        path.addFirst(taken);
        current = gridWorld.tryUndoMove(current, taken);
    }

    return path;


  }
}