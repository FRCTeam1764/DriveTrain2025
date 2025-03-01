package frc.robot.libraries.external.robot.input;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * A Trigger for different directions on a directional-pad.
 *
 * @author Jacob Bublitz
 * @since 1.0
 */
public class DPadButton extends Trigger {

	public enum Direction {
		UP(0),
		UPRIGHT(45),
		RIGHT(90),
		DOWNRIGHT(135),
		DOWN(180),
		DOWNLEFT(225),
		LEFT(270),
		UPLEFT(315),
		CENTER(-1);

		private final int angle;

		Direction(int angle) {
			this.angle = angle;
		}

		public int getAngle() {
			return angle;
		}
	}

	private Joystick joystick;
	private Direction direction;
	private final int pov;

	public DPadButton(Joystick joystick, Direction direction, int pov) {
		super(null); //TODO: FIX
		this.joystick = joystick;
		this.direction = direction;
		this.pov = pov;
	}

	public DPadButton(Joystick joystick, Direction direction) {
		this(joystick, direction, 0);
	}

	
	public boolean get() {
		return joystick.getPOV(pov) == direction.getAngle();
	}
}
