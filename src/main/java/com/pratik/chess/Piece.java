package com.pratik.chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Piece {

	private final Color color;
	private final String origin;
	private Square square;
	private PieceType type;

	public static final String KINGSIDE = "kingside", QUEENSIDE = "queenside", PAWN = "pawn";

	public static final Piece BLANK = new Piece(null, "blank", PieceType.BLANK) {
		@Override
		public boolean canMove(Square target) {
			return false;
		}
	};

	protected Piece(Color color, String origin, PieceType type) {
		this.color = color;
		this.origin = origin;
		this.type = type;
		this.square = null;
	}

	@Override
	public final boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (o.getClass() != this.getClass())
			return false;
		Piece p = (Piece) o;
		if (p.getPieceType() != this.getPieceType())
			return false;
		if (p.getColor() != this.getColor())
			return false;
		if (p.getOrigin().equals(this.getOrigin()))
			return false;
		return true;
	}

	public final String getOrigin() {
		return origin;
	}

	public final Color getColor() {
		return color;
	}

	public final PieceType getPieceType() {
		return type;
	}

	public final Square getSquare() throws InvalidSquareException {
		if (square == null)
			throw new InvalidSquareException("Square for <" + this.toString() + "> is not yet set");
		return square;
	}

	public abstract boolean canMove(Square target);

	@Override
	public final String toString() {
		String str = getColor().toString() + " " + getOrigin() + " " + getPieceType().toString() + " at ";
		try {
			str += getSquare().toString();
		} catch (InvalidSquareException e) {
			str += "null";
		}
		return str;
	}

	public final void setSquare(Square square) throws InvalidSquareException {
		this.square = square;
		if (square.getPiece() != this)
			throw new InvalidSquareException("Multiple piece <" + this.toString() + ", " + square.getPiece().toString()
					+ "> on same Square <" + square.toString() + ">");
	}

	public static final Collection<Piece> newPieces(Color color) {
		List<Piece> pieces = new ArrayList<Piece>(20);
		// ADD PIECESo
		return pieces;
	}
}