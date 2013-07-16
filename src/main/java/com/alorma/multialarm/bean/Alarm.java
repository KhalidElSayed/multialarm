package com.alorma.multialarm.bean;

public class Alarm {

	private String name;
	private int hour;
	private int minute;
	private long id;
	private boolean active = false;
	private boolean disable = false;
	private String soundUri;
	private boolean repeatMode = false;
	private Repeat repeatDays;
    private Long category;

    public Alarm() {

    }

	public Alarm(String name, int hour, int minute, boolean active) {
		this.name = name;
		this.hour = hour;
		this.minute = minute;
		this.active = active;
		this.disable = false;
		this.repeatMode = false;
	}

	public Alarm(long id, String name, int hour, int minute, boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.hour = hour;
		this.minute = minute;
		this.active = active;
		this.disable = false;
		this.repeatMode = false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setSound(String sound) {
		this.soundUri = sound;
	}

	public String getSoundUri() {
		return soundUri;
	}

	public Boolean isDisableAllowed() {
		return disable;
	}

	public void setDisableAllowed(boolean disable) {
		this.disable = disable;
	}

	public Boolean isRepeatMode() {
		return repeatMode;
	}

	public void setRepeatMode(boolean repeatMode) {
		this.repeatMode = repeatMode;
	}

	public Repeat getRepeatDays() {
		return repeatDays;
	}

	public void setRepeatDays(Repeat repeatDays) {
		this.repeatDays = repeatDays;
	}

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }
}
